package com.example.stickhero;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Start2TestRunner {


    public static void main(String[] args) {


        System.out.println("==================================\n");
        System.out.println("Running JUnit tests\n");

        Result result = JUnitCore.runClasses(Start2Test.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

        System.out.println("JUnit tests ended !\n");
        System.out.println("==================================\n");


    }
}