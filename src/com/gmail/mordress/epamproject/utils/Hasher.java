package com.gmail.mordress.epamproject.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Util class for hashing user's password.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class Hasher {

    /** Hashes input string using SHA-256.
     * @param string - string, represents password.
     * @return hashed string, represents password - if hashing was successfull, and null if not. */
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
