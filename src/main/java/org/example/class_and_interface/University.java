package org.example.class_and_interface;

public class University {
    public static void main(String[] args) {

        Student student = new Student("PM-12213", "John Smith", "jsmith@rshu.edu.ua", "KN-31");
        Professor professor = new Professor("Ivan Kulak", "super.star@rshu.edu.ua", "professor");
        Rector rector = new Rector("Super Rector", "rector@rshu.edu.ua");
        Dekan dekan = new Dekan("Stepan Dekan", "dekan@rshu.edu.ua", "Docent", "MIF");

        Security security = new Security();
        System.out.println(professor.greeting());
        System.out.println(student.greeting());
        System.out.println(security.greeting());

    }

}
