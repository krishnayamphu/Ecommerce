package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.Admin;
import com.aptech.models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {

    //get all customer users
    public static ArrayList<Customer> getAllCusotmers() {
        ArrayList<Customer> all_customers = new ArrayList<>();
        Connection cn = ConnectDB.connect();
        String sql = "SELECT * FROM customer";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("customer_id"));
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                String email = rs.getString("email");
                int active = Integer.parseInt(rs.getString("active"));
                String date = rs.getString("created_at");

                Customer customer = new Customer();
                customer.setCid(id);
                customer.setFirstname(fname);
                customer.setLastname(lname);
                customer.setEmail(email);
                customer.setActive(active);
                customer.setCreatedAt(date);

                all_customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_customers;
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

}
