package org.example.exceptions;

import java.io.*;
import java.util.Random;

public class Exceptions {
    public static void main(String args[]) throws IOException {
//        simpleException();
//        withFinallyException();
//        customException();
//        tryWithResourcesException();

    }

    private static void simpleException() {
        try {
            myMethod();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вихід за межі масиву");
        }
        System.out.println("Продовження виконання програми...");
    }

    private static void myMethod() {
        throw new IndexOutOfBoundsException();
    }

    private static void withFinallyException() {
        try {
            System.out.println("The count is " + Integer.parseInt("3.33"));
        } catch (NumberFormatException e) {
            System.out.println("No count");
        } finally {
            System.out.println("In finally");
        }

        //without catch block
        try {
            System.out.println("Inside try");
        } finally {
            System.out.println("Inside finally");
        }
    }

    private static void customException() {
        try {
            myCustomException();
        } catch (IllegalArgumentException | MyCustomException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Продовження виконання програми...");
    }

    private static void myCustomException() {
        if (new Random().nextBoolean()) {
            throw new MyCustomException("this is custom exception");
        } else {
            throw new IllegalArgumentException("this is illegal argument exception");
        }
    }

    private static void tryWithResourcesException() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        try {
            System.out.println(br.readLine());
        } finally {
            if (br != null) {
                br.close();
            }
        }
        //could be changed with
        try (BufferedReader br2 = new BufferedReader(new FileReader("file.txt"))) {
            System.out.println(br2.readLine());
        }
        //or
        try (FileReader f = new FileReader("file.txt");
             BufferedReader br3 = new BufferedReader(f)) {
            System.out.println(br3.readLine());
        }
    }
}
