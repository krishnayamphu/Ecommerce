package com.aptech.dbhelper;

import com.aptech.dao.AdminDao;
import com.aptech.dao.ProductDao;
import com.aptech.models.Admin;
import com.aptech.models.Product;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class TestJDBC {
    public static void main(String[] args) {
//        MessageDigest digest = null;
//        try {
//            digest = MessageDigest.getInstance("SHA-256");
//            byte[] hash = digest.digest("12345".getBytes(StandardCharsets.UTF_8));
//
//            String hex = DatatypeConverter.printHexBinary(hash);
//            System.out.println(hex);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

        ArrayList<Product> latestProduct = ProductDao.getLatestProducts();
        for (Product p : latestProduct) {
            System.out.println(p.getId() + ", " + p.getName());
        }

    }
}
