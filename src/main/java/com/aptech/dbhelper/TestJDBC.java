package com.aptech.dbhelper;


import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestJDBC {
    public static void main(String[] args) {
//        Connection cn = ConnectDB.connect();
//        try {
////            PreparedStatement ps=cn.prepareStatement("SELECT * FROM admin");
////            ResultSet rs=ps.executeQuery();
////            while(rs.next()){
////                System.out.println(rs.getString("email"));
////            }
//
//            PreparedStatement ps =
//                    cn.prepareStatement("INSERT INTO admin (firstname,lastname,password,email,contact) VALUES('ram','thapa','123','email','9814')");
//            int s=ps.executeUpdate();
//            System.out.println(s);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        ArrayList<Admin> adminusers= AdminDao.getAllAdmins();
        for (Admin a:adminusers) {
            System.out.println(a.getEmail());
        }
    }
}
