package com.deisi.inqueritos.utils;

import java.util.Random;
import java.util.StringJoiner;

public class TokenUtils {
    private static final String guide = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456790";

    public static String assembleToken() {
        int blocks = 4;
        int length = 6;
        StringJoiner token = new StringJoiner("-");
        Random random = new Random();

        for (int i = 0; i < blocks; i++) {
            StringBuilder tokenBuilder = new StringBuilder();
            for (int j = 0; j < length; j++) {
                tokenBuilder.append(guide.charAt(random.nextInt(guide.length())));
            }
            token.add(tokenBuilder.toString());
        }
        return token.toString();
    }


}
