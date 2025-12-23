package templates.slidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Driver {




    public static void main(String[] args) throws Exception {
//        MyChecker isEven = n -> n % 2 ==0;
//
//        System.out.println(isEven.check(50));
//        // 1. Predicate - takes input, returns true/false
//        Predicate<Integer>  isGreater = n -> n >50;
//
//        System.out.println(isGreater.test(51));
//
//        // 2. Function - takes input, returns something
//        Function<Integer,Integer>  double_it = n -> n *2;
//
//        double_it.apply(50);
//
//        // 3. Consumer - takes input, does something (no return)
//        Consumer<Integer> printIt = System.out::println;
//        printIt.accept(150);
//
//        Calculator c = (a,b) -> a+b;
//        System.out.println(c.sum(12,24));
//
//
//        Optional<String> opt = Optional.of("Hello");
//
//        if(opt.isPresent()){
//            System.out.println(opt.get());
//        }
//
//        String result = opt.orElse("World");
//
//        // 3. orElseGet() - return value or computed default
//        String results = opt.orElseGet(() -> "computed");
//
//        // 4. orElseThrow() - return value or throw exception
//        String resul = opt.orElseThrow(() -> new Exception("Not found"));
//
//        opt.map(String::toUpperCase)
//                .ifPresent(System.out::println);  // HELLO
//
//        Optional<String> optional = Optional.of("java");
//        optional.ifPresent(System.out::println);
//
//        optional.map(String::toUpperCase).ifPresent(System.out:: println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum all numbers

        Integer sum = numbers.stream().reduce(0,(acc,n) -> acc+n);
        System.out.println(sum);
        // product of all numbers
        Integer product = numbers.stream().reduce(1,(acc,n)-> acc * n);
        System.out.println(product);


        // Find Maximum
        Integer max = numbers.stream().reduce(Integer.MAX_VALUE,(acc,num) -> acc > num ? acc : num );

        // Concatenate strings
        List<String> words = Arrays.asList("hello", "world", "java");
        String concatenate  = words.stream().reduce("",(acc,word) -> acc +" "+word);

        ///*Intermediate 2: groupingBy() - Group Elements by Category
        /// What is groupingBy?
        /// Organizes elements into groups based on some criteria.
        /// Real life: You have a list of students. Group them by their grades (A, B, C).*/


    }
}
