package org.example.class_and_interface;

import java.time.Instant;

public interface Person {
    default String greeting() {
        return "Hello my dear fried @ " + addDate();
    }

    private Instant addDate() {
        return Instant.now();
    }
}
