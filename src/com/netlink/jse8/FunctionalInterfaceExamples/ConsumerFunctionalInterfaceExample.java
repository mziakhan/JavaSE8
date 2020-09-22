package com.netlink.jse8.FunctionalInterfaceExamples;

import com.netlink.jse8.Data.Student;
import com.netlink.jse8.Data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerFunctionalInterfaceExample {
    static Consumer<Student> studentName=(student)-> System.out.println(student.getName());
    static Consumer<Student> studentGrade=(student)-> System.out.print(student.getGradeLevel());
    static Consumer<Student> studentActivities=(student)-> System.out.println(student.getActivities());
    static BiConsumer<String,List<String>>studentNameAndActivities=(name,activities)-> System.out.println("Name: "+name +"and Activities: "+activities);


    public static void printStudetsList(){
        List<Student>studentsList= StudentDatabase.getAllStudents();
        studentsList.forEach(s-> System.out.println(s));
    }

    public static void printNameAndActivities(){
        List<Student>studentsList= StudentDatabase.getAllStudents();
        studentsList.forEach(studentName.andThen(studentGrade).andThen(studentActivities));
    }

    public static void printNameAndActivitiesUsingBiConsumer(){
        List<Student>studentsList= StudentDatabase.getAllStudents();
        studentsList.forEach(student -> {studentNameAndActivities.accept(student.getName(),student.getActivities());});
    }

    public static void printNameAndActivitiesConditionalBasis(){
        List<Student>studentsList= StudentDatabase.getAllStudents();
        studentsList.forEach(student -> {
            if (student.getGradeLevel()>=3.9 && student.getGradeLevel()<= 4.0){
                studentName.accept(student);
            }
        });
    }
    public static void main(String[] args) {
        Consumer<Integer> integerConsumer=(i)-> System.out.println(i.doubleValue()) ;
       // integerConsumer.accept(3000/342);
        //printStudetsList();
      //  printNameAndActivities();
        printNameAndActivitiesConditionalBasis();
        printNameAndActivitiesUsingBiConsumer();
    }
}
