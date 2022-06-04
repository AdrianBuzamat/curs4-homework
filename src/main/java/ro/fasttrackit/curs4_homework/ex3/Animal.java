package ro.fasttrackit.curs4_homework.ex3;


sealed interface Animal permits Dog, Cat, Bird, Insects {
}

final class Dog implements Animal {
}

record Cat() implements Animal {
}

sealed class Bird implements Animal permits Canary, Chicken, Parrot {
}

sealed interface Insects extends Animal permits Fly, Ladybug {
}

final class Canary extends Bird {
}

final class Parrot extends Bird {
}

non-sealed class Chicken extends Bird {
}

final class Fly implements Insects {
}

record Ladybug() implements Insects {
}
