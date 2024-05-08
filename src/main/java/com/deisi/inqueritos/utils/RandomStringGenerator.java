package com.deisi.inqueritos.utils;


import java.util.Random;

public class RandomStringGenerator {

    public static String generateRandomString() {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        // Combine the characters and numbers into one string
        String alphaNumeric = upperAlphabet + numbers;

        // Create StringBuilder to store the result
        StringBuilder sb = new StringBuilder();

        // Create an instance of Random class
        Random random = new Random();

        // Specify the length of the random string
        int length = 6;

        for(int i = 0; i < length; i++) {

            // Generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // Get character specified by index from the alphaNumeric string
            char randomChar = alphaNumeric.charAt(index);

            // Append the character to StringBuilder
            sb.append(randomChar);
        }

        return sb.toString();
    }
}

