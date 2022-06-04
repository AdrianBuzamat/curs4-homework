package ro.fasttrackit.curs4_homework.ex1;

import java.util.*;
import java.util.stream.Collectors;
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
                        %s will participare to course:
                        %s
                        """.formatted(student.name(), getRandomCourse(courses))));
    }

    private String getRandomCourse(List<String> courses) {
        return courses.get(new Random().nextInt(courses.size()));
    }

}
