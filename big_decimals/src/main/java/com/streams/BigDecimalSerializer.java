package com.streams;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 11/5/2017.
 */
public class BigDecimalSerializer {
    private String filename;

    public BigDecimalSerializer(String filename) {
        this.filename = filename;
    }

    public void serializeBigDecimals(List<BigDecimal> numbers){

        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {

            for(BigDecimal number: numbers){
                out.writeObject(number);
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public List<BigDecimal> deserializeBigDecimals(){
        List<BigDecimal> numbers = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {

            try {
                while (true) {
                    numbers.add((BigDecimal) in.readObject());
                }
            }catch (EOFException e) {
                System.out.println("End of file.");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            
        }catch (IOException e){
            e.printStackTrace();
        }
        return numbers;
    }
}
