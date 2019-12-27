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
    public static boolean updateActiveStatus(Customer customer) {
        boolean bool = false;
        Connection cn = ConnectDB.connect();
        String sql = "UPDATE customer SET active=?,updated_at=? WHERE customer_id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, customer.getActive());
            ps.setString(2, customer.getUpdatedAt());
            ps.setInt(3, customer.getCid());
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
