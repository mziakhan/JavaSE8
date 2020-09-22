package com.netlink.jse8.FunctionalInterfaceExamples;

import com.netlink.jse8.Data.Student;
import com.netlink.jse8.Data.StudentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> filterByGrade = student -> student.getGradeLevel() > 3.0;
    static Predicate<Student> filterByGpa = student -> student.getGpa() >= 3.6;
    static Predicate<Student> filterByGender = student -> student.getGender().equalsIgnoreCase("female");
    static List<Student> studentList = StudentDatabase.getAllStudents();

    public static void filterByGradeLevel() {
        System.out.println("filterByGradeLevel----");
        studentList.forEach(student -> {
            if (filterByGrade.test(student)) {
                System.out.println(student);
            }
        });

    }

    public static void filterByGpa() {
        System.out.println("filterByGpa--");
        studentList.forEach(student -> {
            if (filterByGpa.and(filterByGender.negate()).test(student)) {
                System.out.println(student);
            }
        });

    }
    public static void filterByGpaAndGradeLevel() {
        System.out.println("filterByGpaAndGradeLevel--");
        studentList.forEach(student -> {
            if (filterByGpa.and(filterByGrade).test(student)) {
                System.out.println(student);
            }
        });

    }
    public static void noGpaAndGradeLevelCriteria() {
        System.out.println("no gpa and grade level criteria students--");
        studentList.forEach(student -> {
            if (filterByGpa.and(filterByGrade).negate().test(student)) {
                System.out.println(student);
            }
        });

    }
    public static void gettingActivitiesOfEligibleStudents() {
        System.out.println("gettingActivitiesOfEligibleStudents------");
        studentList.forEach(student -> {
            if (filterByGpa.and(filterByGrade).test(student)) {
                System.out.print(student.getName());
                System.out.println(student.getActivities());
            }
        });

    }
    public static void gettingActivitiesOfNotEligibleStudents() {
        System.out.println("gettingActivitiesOfEligibleStudents------");
        studentList.forEach(student -> {
            if (filterByGpa.and(filterByGrade).negate().test(student)) {
                System.out.print(student.getName());
                System.out.println(student.getActivities());
            }
        });

    }

    public static void main(String[] args) {
       // filterByGradeLevel();
     //   filterByGpa();
//       filterByGpaAndGradeLevel();
       // noGpaAndGradeLevelCriteria();
//        gettingActivitiesOfEligibleStudents();
        gettingActivitiesOfNotEligibleStudents();
    }
}
