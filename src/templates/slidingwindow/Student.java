package templates.slidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }




    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 75),
                new Student("Charlie", 85),
                new Student("David", 75)
        );

        Map<Integer,List<Student>> studentByGroup = students.stream().collect(Collectors.groupingBy(s -> s.grade));


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    }
}

