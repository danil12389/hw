package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        posts.stream()
                        .map(i -> i.split(""))
        .filter(i -> Arrays.stream(i).allMatch(x -> x.substring(0).equals("#")))
                .map(i -> result.add(i))
         .forEach(System.out::println);
        System.out.println(posts.size());
    }
}