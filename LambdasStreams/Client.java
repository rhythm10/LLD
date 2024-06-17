package LambdasStreams;


import HelloWorldUsingThreads.PrintHelloWorld;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {

        List<Student> lsStudent = new ArrayList<>();
        Student st1 = new Student(10, 90.0,"ABC");
        Student st2 = new Student(4, 81.0,"GHU");
        Student st3 = new Student(7, 87.0,"KBC");
        lsStudent.add(st1);
        lsStudent.add(st2);
        lsStudent.add(st3);

        Collections.sort(lsStudent, (Student s1, Student s2) -> {
            return s1.univName.compareTo(s2.univName);
        });
        for(Student s : lsStudent) {
            System.out.println(s.univName);
        }

        PrintHelloWorLd task = new PrintHelloWorLd();
        Thread t = new Thread(task);
        t.start();

        Runnable r = () -> {
            System.out.println("Hello World");
        };
        Thread t2 = new Thread(r);
        t2.start();

        Thread t3 = new Thread(() -> {
                System.out.println("Hello World");
        });
        t3.start();

        Thread t4 = new Thread(() -> System.out.println("Hello World"));
        t4.start();

        MathematicalOperation additionOperation = new AdditionOperation();
        System.out.println(additionOperation.operate(2,5));

        MathematicalOperation op1 = (a, b) ->  a + b;
        int res = op1.operate(2, 4);
        System.out.println(res);

        MathematicalOperation op2 = (a, b) -> a - b;
        int res2 = op2.operate(10, 6);
        System.out.println(res2);

        List<Integer> ls = List.of(2,4,5,6,1,2,4,5,4);
        Stream<Integer> s1 = ls.stream();
        Stream<Integer> s2 = ls.stream();
//        System.out.println(s1.limit(5));
        System.out.println(s1.limit(1).count());

        s2.limit(3).forEach((elem) -> {
            System.out.println("elemtent : " + elem);
        });

        List<Integer> filteredls = ls.
                stream().
                filter((elem) -> { return elem % 2 == 0;}).
                map((elem) -> elem * elem).
                sorted((x,y) -> {return y-x;}).
                collect(Collectors.toList());

//        List<Integer> filteredls1 = ls.
//                stream().
//                filter((elem) ->  elem % 2 == 0).
//                collect(Collectors.toList());

        System.out.println(filteredls);

        Optional<Integer> filteredls1 = ls.
                stream().
                filter((elem) -> { return elem % 2 == 0;}).
                map((elem) -> elem * elem).
                sorted((x,y) -> {return y-x;}).
                findFirst();

        System.out.println(filteredls1);

        Integer filteredls3 = ls.
                stream().
                filter((elem) -> { return elem % 2 == 0;}).
                map((elem) -> elem * elem).
                sorted((x,y) -> {return y-x;}).
                reduce(0, (a,b) -> a+b);

        System.out.println(filteredls3);

        int sum = ls.stream().mapToInt(elem -> elem).sum();
        System.out.println(sum);






    }
}
