package com.person;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Laura on 11/14/2017.
 */
public class Main {

    private static void restoreObjects(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("producer_consumer/src/main/resources/output.txt", true));
            Scanner scanner = new Scanner(new File("producer_consumer/src/main/resources/input4.txt")).useDelimiter("%")) {

            int total = 0;
            int valid = 0;
            while(scanner.hasNext()) {
                total += 1;
                String nextPerson = scanner.next();
                if (Util.isValid(nextPerson)) {
                    valid += 1;
                    Person person = Util.createPerson(nextPerson);
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
        restoreObjects();
        System.out.println();
        restoreObjectsWithProducerConsumer();
    }
}
