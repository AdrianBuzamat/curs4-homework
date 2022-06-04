package ro.fasttrackit.curs4_homework.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StudentService {
    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = Optional.ofNullable(students)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public String avgGradeFor3Students(){
        return students.stream()
                .limit(3)
                .collect(teeing(
                        Collectors.mapping(Student::name, toList()),
                        averagingDouble(Student::grade),
                        (list, avg)-> list.stream().collect(joining(", ")) + " have an average grade of " + String.format("%.2f", avg)));
    }

    public void textBlocks() {
        System.out.println("""
                {
                    "course" : "%s",
                    "semester" : "%s",
                }
                """.formatted("Math101", "2"));
    }

}
