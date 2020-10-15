package com.mangsuktech.mediahelper;

import java.io.File;
import java.util.ArrayList;

public class MediaHelper {
    //all media files
    public static ArrayList<String> getMediaList() {
        ArrayList<String> allFiles = new ArrayList<>();
        File file = new File("uploads");
        if (file.exists()) {
            File[] listOfFiles = file.listFiles();
            for (File myFile : listOfFiles) {
                if (myFile.isFile())
                    allFiles.add(myFile.getName());
            }
        } else {
            System.out.println("no such a file");
        }
        return allFiles;
    }

    //delete media file
    public static boolean deleteMedia(String imageName) {
        boolean status = false;
        String path = "uploads";
        File file = new File(path);
        if (file.exists()) {
            String[] filename = file.list();
            for (String name : filename) {
                if (name.equals(imageName)) {
                    File myFile = new File(path + "\\" + name);
                    myFile.delete();
                    status = true;
                    System.out.println(name + " is deleted");
                }
                System.out.println(name);
            }
        } else {
            System.out.println("no such a file");
        }
        return status;
    }
}
