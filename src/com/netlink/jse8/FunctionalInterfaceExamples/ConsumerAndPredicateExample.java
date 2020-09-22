package com.netlink.jse8.FunctionalInterfaceExamples;

import com.netlink.jse8.Data.Student;
import com.netlink.jse8.Data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerAndPredicateExample {

    Predicate<Student> filterByGrade = student -> student.getGradeLevel() >=3;
    Predicate<Student> filterByGpa = student -> student.getGpa() >= 3.6;
    static BiConsumer<String, List<String>> studentNameAndActivities=(name, activities)-> System.out.println("Name: "+name +", Activities: "+activities);
    Consumer<Student>studentConsumer=student->{
            if(filterByGrade.and(filterByGpa).test(student)){
                studentNameAndActivities.accept(student.getName(),student.getActivities());
            }
    };
    public void activitiesOfEligibleStudents(List<Student> studentList){
        studentList.forEach(studentConsumer);
    }
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        new ConsumerAndPredicateExample().activitiesOfEligibleStudents(studentList);
    }
}
