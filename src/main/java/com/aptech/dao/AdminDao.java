package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    //admin login
    public static int login(String email, String password){
        int count=0;
        Connection cn= ConnectDB.connect();
        String sql="SELECT * FROM admin WHERE email=? AND password=?";
        try {
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    //create admin user
    public static int saveAdmin(String firstname, String lastname, String password, String email,String contact){

        return 0;
    }
}
