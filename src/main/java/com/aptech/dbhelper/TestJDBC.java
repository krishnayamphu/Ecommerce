package com.aptech.dbhelper;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestJDBC {
    public static void main(String[] args) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest("12345".getBytes(StandardCharsets.UTF_8));

            String hex = DatatypeConverter.printHexBinary(hash);
            System.out.println(hex);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
