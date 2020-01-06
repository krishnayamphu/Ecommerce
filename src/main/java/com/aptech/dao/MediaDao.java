package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.Media;
import com.aptech.models.ProductType;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MediaDao {

    //get all media files
    public static ArrayList<Media> getAllMediaTypes() {
        ArrayList<Media> all_media_types = new ArrayList<>();
        Connection cn = ConnectDB.connect();
        String sql = "SELECT * FROM media";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String path = rs.getString("path");
                String date = rs.getString("created_at");

                Media media = new Media();
                media.setId(id);
                media.setName(name);
                media.setPath(path);
                media.setCreatedAt(date);
                all_media_types.add(media);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_media_types;
    }

    //upload media
    public static int saveMedia(Media media) {
        int status = 0;
        Connection cn = ConnectDB.connect();
        String sql = "INSERT INTO media (name,path) VALUES(?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, media.getName());
            ps.setString(2, media.getPath());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    //delete media
    public static boolean deleteMedia(Media media) {
        boolean bool = false;
        Connection cn = ConnectDB.connect();
        String sql = "DELETE FROM media WHERE id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, media.getId());
            int status = ps.executeUpdate();
            if (status == 1) {
                String path = "C:\\Users\\Krishna Yamphu\\Desktop\\Ecommerce\\src\\main\\webapp\\uploads";
                String mPath = "C:\\Users\\Krishna Yamphu\\Desktop\\Ecommerce\\src\\main\\webapp\\uploads\\";

                File file = new File(path);
                if (file.exists()) {
                    String[] filename = file.list();
                    for (String name : filename) {
                        if (name.equals(media.getName())) {
                            File myFile = new File(mPath + name);
                            myFile.delete();
                            System.out.println(name + " is deleted");
                        }
                    }
                } else {
                    System.out.println("no such a file");
                }
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }
}
