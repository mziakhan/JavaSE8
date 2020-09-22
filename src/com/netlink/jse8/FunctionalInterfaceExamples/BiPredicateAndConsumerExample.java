package com.netlink.jse8.FunctionalInterfaceExamples;

import com.netlink.jse8.Data.Student;
import com.netlink.jse8.Data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BiPredicateAndConsumerExample {
    BiPredicate<Integer,Double> filterByGradeAndGpa=(gradeLevel,gpa)->gradeLevel >=3 && gpa>= 3.6;
    BiPredicate<Integer,Double> filterByGradeOrGpa=(gradeLevel,gpa)->gradeLevel >=3 || gpa>= 3.6;

    static BiConsumer<String, List<String>> studentNameAndActivities=(name, activities)-> System.out.println("Name: "+name +", Activities: "+activities);
    Consumer<Student> studentConsumer= student->{
        if(filterByGradeOrGpa.test(student.getGradeLevel(),student.getGpa())){
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
