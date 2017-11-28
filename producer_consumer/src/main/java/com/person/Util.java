package com.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Laura on 11/14/2017.
 */
public class Util {

    public static boolean isValid(String string, Pattern pattern){
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
