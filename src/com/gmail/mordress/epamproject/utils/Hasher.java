package com.gmail.mordress.epamproject.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Hasher {

    public static String SHA256(String string) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(string.getBytes());
            byte hash[] = digest.digest();
            Formatter formatter = new Formatter();
            for(int i = 0; i < hash.length; i++) {
                formatter.format("%02X", hash[i]);
            }
            return formatter.toString();
        } catch(NoSuchAlgorithmException e) {
            return null;
        }
    }
}
