package org.example.class_and_interface;

import java.io.Serializable;

public class Dekan extends Professor implements Person, Cloneable, Serializable {

    private String facultyIdentifier;

    public Dekan(String name, String email, String academicDegree, String facultyIdentifier) {
        super(name, email, academicDegree);
        this.facultyIdentifier = facultyIdentifier;
    }
}
