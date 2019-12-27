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

    //get single admin user
    public static ArrayList<Admin> getSingleAdminUser(int id){
        ArrayList<Admin> single_admin=new ArrayList<>();
        Connection cn=ConnectDB.connect();
        String sql="SELECT * FROM admin WHERE id=?";
        try {
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int admin_id=Integer.parseInt(rs.getString("id"));
                String fname=rs.getString("firstname");
                String lname=rs.getString("lastname");
                String password=rs.getString("password");
                String email=rs.getString("email");
                String contact=rs.getString("contact");

                Admin admin=new Admin();
                admin.setId(admin_id);
                admin.setFirstname(fname);
                admin.setLastname(lname);
                admin.setPassword(password);
                admin.setEmail(email);
                admin.setContact(contact);

                single_admin.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return single_admin;
    }

    //update admin user
    public static boolean updateAdmin(Admin admin) {
        boolean bool = false;
        Connection cn = ConnectDB.connect();
        String sql = "UPDATE admin SET firstname=?,lastname=?,email=?,contact=?,password=?,updated_at=? WHERE id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, admin.getFirstname());
            ps.setString(2, admin.getLastname());
            ps.setString(3, admin.getEmail());
            ps.setString(4, admin.getContact());
            ps.setString(5, admin.getPassword());
            ps.setString(6, admin.getUpdatedAt());
            ps.setInt(7, admin.getId());
            int status = ps.executeUpdate();
            if (status == 1) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    //delete admin user
    public static boolean deleteAdmin(int id) {
        boolean bool = false;
        Connection cn = ConnectDB.connect();
        String sql = "DELETE FROM admin WHERE id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int status = ps.executeUpdate();
            if (status == 1) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }



}
