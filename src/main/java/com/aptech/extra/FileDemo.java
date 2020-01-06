package com.aptech.extra;

import com.aptech.dao.MediaDao;
import com.aptech.models.Media;

import java.io.File;
import java.util.ArrayList;

public class FileDemo {
    public static void main(String[] args) {
        ArrayList<Media> all = MediaDao.getAllMediaTypes();
        for (Media m : all) {
            System.out.println(m.getName());
        }
    }
}
