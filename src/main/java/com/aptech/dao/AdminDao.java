package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        int status=0;
        Connection cn=ConnectDB.connect();
        String sql="INSERT INTO admin (firstname,lastname,password,email,contact) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,firstname);
            ps.setString(2,lastname);
            ps.setString(3,password);
            ps.setString(4,email);
            ps.setString(5,contact);
            status=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    //get all admin users
    public static ArrayList<Admin> getAllAdmins(){
        ArrayList<Admin> all_admins=new ArrayList<>();
        Connection cn=ConnectDB.connect();
        String sql="SELECT * FROM admin";
        try {
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=Integer.parseInt(rs.getString("id"));
                String fname=rs.getString("firstname");
                String lname=rs.getString("lastname");
                String email=rs.getString("email");
                String date=rs.getString("created_at");

                Admin admin=new Admin();
                admin.setId(id);
                admin.setFirstname(fname);
                admin.setLastname(lname);
                admin.setEmail(email);
                admin.setCreatedAt(date);

                all_admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_admins;
    }

}
