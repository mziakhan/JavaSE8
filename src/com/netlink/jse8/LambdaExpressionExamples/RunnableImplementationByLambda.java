package com.netlink.jse8.LambdaExpressionExamples;

public class RunnableImplementationByLambda {

    public static void main(String[] args) {
        //Legacy prior java 8

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside legacy implemmentation prior java 8");
            }
        };
    new Thread(runnable).start();
        //New Implementation with Lambda Expression java 8
        //1
        Runnable runnable1=()->{System.out.println("Inside new implemmentation with java 8");};
        new Thread(runnable1).start();

        //2
        Runnable runnable2=()-> System.out.println("Inside new implemmentation with java 8-2");
        new Thread(runnable2).start();

        //3
        new Thread(()-> System.out.println("Inside new implemmentation with java 8-3")).start();

    }
}
