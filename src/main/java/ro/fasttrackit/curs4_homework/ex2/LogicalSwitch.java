package ro.fasttrackit.curs4_homework.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class LogicalSwitch {
    private final Map<Predicate<Person>, Function<Person, String>> logic;

    public LogicalSwitch(Map<Predicate<Person>, Function<Person, String>> logic) {
        this.logic = logic;
    }
}
