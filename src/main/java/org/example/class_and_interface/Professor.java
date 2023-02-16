package org.example.class_and_interface;

public class Professor extends User implements Person {

    private String workNumber;

    private String academicDegree;

    public Professor(String name, String email, String academicDegree) {
        super(name, email);
        this.academicDegree = academicDegree;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    @Override
    public String greeting() {
        return "Hello sir, my name is " + super.getName();
    }
}
