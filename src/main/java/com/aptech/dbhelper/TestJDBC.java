package com.aptech.dbhelper;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        Connection cn=ConnectDB.connect();
        try {
            PreparedStatement ps=cn.prepareStatement("SELECT * FROM admin");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
