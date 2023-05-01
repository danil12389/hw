package org.example;

import java.util.Objects;

@FunctionalInterface()
public interface CapitalLetterChecker<T> {

    boolean  test(T t);
}
