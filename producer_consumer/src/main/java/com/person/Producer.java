package com.person;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

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

            int total = 0;
            while (scanner.hasNext()) {
                total += 1;
                String nextPerson = scanner.next();
                if (Util.isValid(nextPerson)) {
                    Person person = Util.createPerson(nextPerson);
                    queue.put(person);
                }
            }
            System.out.println("Total in Producer: " + total);

        }  catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
