package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
       //Пример кастомного функционального интерфейса, проверяет что в строке
        // первая буква - заглавная, остальные - строчные.
        CapitalLetterChecker<String> f = x -> x.substring(0, 1).equals(x.substring(0,1).toUpperCase() )&& x.substring(1).equals(x.substring(1).toLowerCase());
        System.out.println(f.test("AAc")); //false
        System.out.println(f.test("Abc")); //true
        System.out.println(f.test("abc")); //false

        List<String> posts = Arrays.asList(
                "Hi everyone #me #hello #me",
                "Hi everyone. I am Alex #alex #helloworld #me #hello",
                "Hi! I am Alex #alex #helloworld #me #hello"
        );
        List<String> result = new ArrayList<>();
        Map<String, String> counters = new HashMap<>();
        var res = posts.stream()
                        .flatMap(x -> Arrays.stream(x.split(" ")))
                                .filter(x -> x.substring(0, 1).equals("#"))
                                        .collect(groupingBy(Function.identity(),counting()));


        System.out.println(res);
    }
}