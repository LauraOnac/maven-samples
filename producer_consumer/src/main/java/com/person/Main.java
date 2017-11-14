package com.person;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Laura on 11/14/2017.
 */
public class Main {

    private static boolean isValidPerson(String person){
        Pattern pattern = Pattern.compile("[a-zA-z]+~[a-zA-Z]+~[a-zA-Z]+~[12][0-9]{12}~[a-zA-Z._]+@[a-z]+.com");
        Matcher matcher = pattern.matcher(person);
        return matcher.matches();
    }

    private static Person createPerson(String person){
        String[] tokens = person.split("~");
        String name1 = tokens[0];
        String name2 = tokens[1];
        String name3 = tokens[2];
        Long CNP = Long.parseLong(tokens[3]);
        String email = tokens[4];
        return new Person(name1, name2, name3, CNP, email);
    }

    public static void main(String[] args){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("producer_consumer/src/main/resources/output.txt", true));
            Scanner scanner = new Scanner(new File("producer_consumer/src/main/resources/input4.txt")).useDelimiter("%")) {

            int total = 0;
            int valid = 0;
            while(scanner.hasNext()) {
                String nextPerson = scanner.next();
                total += 1;
                if (isValidPerson(nextPerson)) {
                    valid += 1;
                    Person person = createPerson(nextPerson);
                    bufferedWriter.write(person.toString());
                }
            }
            System.out.println("Total: " + total);
            System.out.println("Valid: " + valid);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
