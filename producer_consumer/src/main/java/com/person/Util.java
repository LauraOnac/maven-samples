package com.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Laura on 11/14/2017.
 */
public class Util {

    public static boolean isValid(String person){
        Pattern pattern = Pattern.compile("[a-zA-z]+~[a-zA-Z]+~[a-zA-Z]+~[12][0-9]{12}~[a-zA-Z._]+@[a-z]+.com");
        Matcher matcher = pattern.matcher(person);
        return matcher.matches();
    }

    public static Person createPerson(String person){
        String[] tokens = person.split("~");
        String name1 = tokens[0];
        String name2 = tokens[1];
        String name3 = tokens[2];
        Long CNP = Long.parseLong(tokens[3]);
        String email = tokens[4];
        return new Person(name1, name2, name3, CNP, email);
    }
}
