package com.person;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;

/**
 * Created by Laura on 11/14/2017.
 */
public class Producer extends Thread {

    private BlockingQueue<Person> queue;

    public Producer(BlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        try(Scanner scanner = new Scanner(new File("producer_consumer/src/main/resources/input4.txt")).useDelimiter("%")) {

            Pattern pattern = Pattern.compile("[a-zA-z]+~[a-zA-Z]+~[a-zA-Z]+~[12345678]([1-9][0-9]|0[1-9])(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[01])(0[1-9]|[1-3][0-9]|4[0-6]|5[12])([0-9][0-9][1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])[0-9]~[a-zA-Z._]+@[a-z]+.com");
            int total = 0;
            while (scanner.hasNext()) {
                total += 1;
                String nextPerson = scanner.next();
                if (Util.isValid(nextPerson, pattern)) {
                    String[] tokens = nextPerson.split("~");
                    String name1 = tokens[0];
                    String name2 = tokens[1];
                    String name3 = tokens[2];
                    Long CNP = Long.parseLong(tokens[3]);
                    String email = tokens[4];
                    Person person = new Person(name1, name2, name3, CNP, email);
                    queue.put(person);
                }
            }
            Person poisonPill = new Person("","","",0l,"");
            queue.put(poisonPill);
            System.out.println("Total in Producer: " + total);

        }  catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
