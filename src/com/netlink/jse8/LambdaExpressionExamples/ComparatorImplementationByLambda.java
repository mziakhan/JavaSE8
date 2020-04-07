package com.netlink.jse8.LambdaExpressionExamples;

import java.util.Comparator;

public class ComparatorImplementationByLambda {

    public static void main(String[] args) {

        //legacy way prior java 8
        Comparator<Integer> comparator =new
                Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                };
        System.out.println("before java 8:"+ comparator.compare(32,76));
    //Way 1
        Comparator<Integer> comparator1=(Integer i1, Integer i2)->{return i1.compareTo(i2);};
        System.out.println("After java 8:"+ comparator.compare(32,76));

    //Way 2
        Comparator<Integer> comparator2=(i1,i2)-> i1.compareTo(i2);
        System.out.println("After java 8:"+ comparator.compare(32,76));

    }
}
