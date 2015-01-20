package com.mindbottle;

import java.util.Arrays;
import java.util.List;

public class IsNumber {

    public static void main(String[] args) {
        System.out.println(IsNumber("123"));
        System.out.println(IsNumber("1.23"));
        System.out.println(IsNumber("1.2.3"));
        System.out.println(IsNumber("-1.23"));
    }

    // Write a function to determine if a string is a number without using any built-in function.
    public static boolean IsNumber(String num) {
        // corner cases
        if (num.isEmpty()) {
            return false;
        }

        // Note: List initialisation
        List<Character> numbers = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0');
        // convert String to array of chars
        char[] numChars = num.toCharArray();

        boolean decimal = false;
        // loop through each character of
        for (int i=0; i<numChars.length; i++) {
            if (i==0 && numChars[0] == '-') {
                // negative number
                continue;
            }
            else if (!decimal && numChars[i] == '.') {
                decimal = true;
                continue;
            }
            else if (!numbers.contains(numChars[i])) {
                // not a number
                return false;
            }
        }
        return true;
    }
}

