package com.aptech.extra;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("d:\\new");
        if (file.exists()) {
            String[] filename = file.list();
            for (String name : filename) {
//                System.out.println(name);
                if (name.equals("a.png")) {
                    File myFile = new File("d:\\new\\" + name);
                    myFile.delete();
                    System.out.println(name + " is deleted");
                }
            }
        } else {
            System.out.println("no such a file");
        }
    }
}
