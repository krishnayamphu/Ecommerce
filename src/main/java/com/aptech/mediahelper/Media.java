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

    public static boolean deleteMedia(String imageName) {
        boolean status = false;
        String path = "C:\\Users\\Krishna Yamphu\\Desktop\\Ecommerce\\src\\main\\webapp\\uploads";
        String mPath = "C:\\Users\\Krishna Yamphu\\Desktop\\Ecommerce\\src\\main\\webapp\\uploads\\";

        File file = new File(path);
        if (file.exists()) {
            String[] filename = file.list();
            for (String name : filename) {
                if (name.equals(imageName)) {
                    File myFile = new File(mPath + name);
                    myFile.delete();
                    status = true;
                    System.out.println(name + " is deleted");
                }
            }
        } else {
            System.out.println("no such a file");
        }
        return status;
    }

    public static void main(String[] args) {
//        deleteMedia("avatar2.png");
    }
}
