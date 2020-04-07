package com.netlink.jse8.FunctionalInterfaceExamples;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {
        BiConsumer<Integer,Integer>multiply=(i1,i2)-> System.out.println("Multiplication "+i1*i2);
        BiConsumer<Integer,Integer>division=(i1,i2)-> System.out.println("Division "+i1/i2);
        BiConsumer<Integer,Integer>addition=(i1,i2)-> System.out.println("Addition "+(i1+i2));
        BiConsumer<Integer,Integer>subtraction=(i1,i2)-> System.out.println("subtraction "+(i1-i2));
        BiConsumer<Integer,Integer>modulo=(i1,i2)-> System.out.println("subtraction "+(i1%i2));

        subtraction.andThen(addition).andThen(modulo).accept(54,12);

    }
}
