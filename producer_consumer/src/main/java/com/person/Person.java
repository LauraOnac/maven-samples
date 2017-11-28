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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!name1.equals(person.name1)) return false;
        if (!name2.equals(person.name2)) return false;
        if (!name3.equals(person.name3)) return false;
        if (!CNP.equals(person.CNP)) return false;
        return email.equals(person.email);
    }

    @Override
    public int hashCode() {
        int result = name1.hashCode();
        result = 31 * result + name2.hashCode();
        result = 31 * result + name3.hashCode();
        result = 31 * result + CNP.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
