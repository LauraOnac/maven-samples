package com.person;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * Created by Laura on 11/14/2017.
 */
public class Main {

    private static void restoreObjects(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("producer_consumer/src/main/resources/output.txt", true));
            Scanner scanner = new Scanner(new File("producer_consumer/src/main/resources/input4.txt")).useDelimiter("%")) {

            Pattern pattern = Pattern.compile("[a-zA-z]+~[a-zA-Z]+~[a-zA-Z]+~[12345678]([1-9][0-9]|0[1-9])(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[01])(0[1-9]|[1-3][0-9]|4[0-6]|5[12])([0-9][0-9][1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])[0-9]~[a-zA-Z._]+@[a-z]+.com");
            int total = 0;
            int valid = 0;
            while(scanner.hasNext()) {
                total += 1;
                String nextPerson = scanner.next();
                if (Util.isValid(nextPerson, pattern)) {
                    valid += 1;
                    String[] tokens = nextPerson.split("~");
                    String name1 = tokens[0];
                    String name2 = tokens[1];
                    String name3 = tokens[2];
                    Long CNP = Long.parseLong(tokens[3]);
                    String email = tokens[4];
                    Person person = new Person(name1, name2, name3, CNP, email);
                    bufferedWriter.write(person.toString());
                }
            }
            System.out.println("Total: " + total);
            System.out.println("Valid: " + valid);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void restoreObjectsWithProducerConsumer(){
        BlockingQueue<Person> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        /*
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        restoreObjects();
        System.out.println();
        restoreObjectsWithProducerConsumer();
    }
}
