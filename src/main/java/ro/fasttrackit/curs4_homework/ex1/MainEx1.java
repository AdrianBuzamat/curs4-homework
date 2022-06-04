package ro.fasttrackit.curs4_homework.ex1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MainEx1 {
    public static void main(String[] args) {
        Student st = new Student("Alexa", 33, 9);
        System.out.println(st.getAge());

        StudentService studentService = new StudentService(
                List.of(
                        new Student("Maria Patru", LocalDate.of(1986, 3, 22), 9.0)
                        , new Student("Dragos Axinte", LocalDate.of(1988, 8, 12), 8.4)
                        , new Student("Marius Dobrescu", LocalDate.of(1987, 6, 22), 7.5)
                        , new Student("Cipran Baciu", 33, 8.5)
                        , new Student("Paula Ivinca", LocalDate.of(1989, 7, 6), 9.5)
                        , new Student("Irina Domni", LocalDate.of(1986, 3, 22), 7.4)
                ));

        System.out.println(studentService.avgGradeFor3Students());

        var courses = Arrays.asList(
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

        studentService.randomAllocationCourse(courses);

    }
}
