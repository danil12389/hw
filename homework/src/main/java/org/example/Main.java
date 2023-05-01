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
    }
}