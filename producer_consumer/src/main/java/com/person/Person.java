package com.person;

/**
 * Created by Laura on 11/14/2017.
 */
public class Person {
    private String name1;
    private String name2;
    private String name3;
    private Long CNP;
    private String email;

    public Person(String name1, String name2, String name3, Long CNP, String email) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.CNP = CNP;
        this.email = email;
    }

    public Person() {
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public Long getCNP() {
        return CNP;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "%" +
                name1 + "~" +
                name2 + "~" +
                name3 + "~" +
                CNP + "~" +
                email;
    }
}
