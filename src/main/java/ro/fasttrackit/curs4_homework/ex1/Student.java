package ro.fasttrackit.curs4_homework.ex1;

import java.time.LocalDate;
import java.time.Period;

import static java.util.random.RandomGenerator.*;

public record Student(String name, LocalDate birthday, Double grade) {
    public Student(String name, int age, double grade){
        this(name, LocalDate.of(age, getDefault().nextInt(1, 12),getDefault().nextInt(1, 31)), grade);
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
