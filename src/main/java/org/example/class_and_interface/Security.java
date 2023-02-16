package org.example.class_and_interface;

import java.time.Instant;

public class Security extends User implements Person {

    public static String codeWord = "rshu-forever";
    public static String timePrefix = "Kyiv time is: ";
    public static String getCurrentDate(){
        return timePrefix + Instant.now();
    }

    public Security() {
        super(null, null);
    }

    public Security(String name, String email) {
        super(name, email);
    }

    @Override
    public String greeting() {
        return "go away!";
    }
}
