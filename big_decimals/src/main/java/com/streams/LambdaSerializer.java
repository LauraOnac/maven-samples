package com.streams;

import java.io.*;
import java.math.BigDecimal;
import java.util.function.BiFunction;

/**
 * Created by Laura on 11/9/2017.
 */
public class LambdaSerializer {
    private String filename;

    public LambdaSerializer(String filename) {
        this.filename = filename;
    }

    public void serializeLambda(BiFunction<BigDecimal,BigDecimal,BigDecimal> lambda){
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            out.writeObject(lambda);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public BiFunction<BigDecimal,BigDecimal,BigDecimal> deserializeLambda(){
        BiFunction<BigDecimal,BigDecimal,BigDecimal> lambda = (n1,n2) -> BigDecimal.ZERO;
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            try {
                lambda = (BiFunction<BigDecimal,BigDecimal,BigDecimal>) in.readObject();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return lambda;
    }
}
