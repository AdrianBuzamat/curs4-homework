package ro.fasttrackit.curs4_homework.ex1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StudentService {
    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = Optional.ofNullable(students)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public String avgGradeFor3Students() {
        return students.stream()
                .limit(3)
                .collect(teeing(
                        Collectors.mapping(Student::name, toList()),
                        averagingDouble(Student::grade),
                        (list, avg) -> list.stream().collect(joining(", "))
                                + " have an average grade of "
                                + String.format("%.2f", avg)));
    }

    public void randomAllocationCourse(List<String> courses) {
        students.stream().forEach(
                student -> System.out.println("""
                        %s will participate to course:
                        %s
                        """.formatted(student.name(), getRandomCourse(courses))));
    }

    private String getRandomCourse(List<String> courses) {
        return courses.get(new Random().nextInt(courses.size()));
    }

    public String getRankedList(){
        var temp = sortByGrade(students);
        return IntStream.range(0, students.size())
                .mapToObj(i->temp.get(i).name()+": "+setRanks(i))
                .collect(joining("\n"));
    }

    private List<Student> sortByGrade(List<Student> list2reverse){
        return students.stream().sorted(Comparator.comparing(Student::grade).reversed()).toList();
    }

    private String setRanks(int index){
        return switch (index) {
            case 0, 1, 2-> "1st grade";
            case 3 -> "5th grade";
            default -> "7th grade";
        };
    }
}
