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

    public void textBlocks() {
        System.out.println("""
                {
                    "course" : "%s",
                    "semester" : "%s",
                }
                """.formatted("Math101", "2"));
    }

    public List<String> getCourses() {
        return Arrays.asList(
                """
                        {
                            "course" : "math101",
                            "semester": "2"
                        }
                        """,
                """
                        {
                            "course" : "history202",
                            "semester": "1"
                        }
                        """,
                """
                        {
                            "course" : "enghlish102",
                            "semester": "1"
                        }
                        """
        );
    }

    public Map<String, String> randomAllocationCourse(List<String> courses) {
        Map<String, String> result = new HashMap<>();

        students.stream().forEach(student -> result.put(student.name(), getRandomCourse(courses)));

        return result;
    }

    private String getRandomCourse(List<String> courses) {
        return courses.get(new Random().nextInt(courses.size()));
    }

}
