package com.netlink.jse8.FunctionalInterfaceExamples;

import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> p = (i) -> i % 2 == 0;
    static Predicate<Integer> p1 = (i) -> i % 5 == 0;

    public static void predicateAnd(Integer no){
        System.out.println(p.and(p1).test(no));
    }
    public static void predicateOr(Integer no){
        System.out.println(p.or(p1).test(no));
    }
    public static void predicateNegate(Integer no){
        System.out.println(p.or(p1).negate().test(no));
    }
    public static void main(String[] args) {

//        System.out.println(p.test(5));
        predicateAnd(9);
        predicateOr(8);
        predicateNegate(7);

    }
}
