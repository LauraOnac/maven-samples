package com.person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Laura on 11/14/2017.
 */
public class Consumer extends Thread {

    private BlockingQueue<Person> queue;

    public Consumer(BlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("producer_consumer/src/main/resources/consumer_output.txt", true))){

            int valid = 0;
            Person poisonPill = new Person("","","",0l,"");
            Person person = queue.take();
            while(!person.equals(poisonPill)) {
                valid += 1;
                bufferedWriter.write(person.toString());
                person = queue.take();
            }
            System.out.println("Valid in Consumer: " + valid);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
