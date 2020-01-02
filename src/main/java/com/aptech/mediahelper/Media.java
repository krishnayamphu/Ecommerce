package com.aptech.mediahelper;

import java.io.File;
import java.util.ArrayList;

public class Media {
    public static ArrayList<String> getMediaList() {
        ArrayList<String> allFiles = new ArrayList<>();
        File file = new File("C:\\Users\\Krishna Yamphu\\Desktop\\Ecommerce\\src\\main\\webapp\\uploads");
        if (file.exists()) {
            File[] listOfFiles = file.listFiles();
            for (File myFile : listOfFiles) {
                if (myFile.isFile())
//                System.out.println(myFile.getName());
                    allFiles.add(myFile.getName());
            }
        } else {
            System.out.println("no such a file");
        }
        return allFiles;
    }

    public static void main(String[] args) {
        ArrayList<String> myfiles = getMediaList();
        for (String f : myfiles) {
            System.out.println(f);
        }
    }
}
