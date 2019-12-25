package com.aptech.dbhelper;


import com.aptech.dao.AdminDao;
import com.aptech.dao.CustomerDao;
import com.aptech.models.Admin;
import com.aptech.models.Customer;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestJDBC {
    public static void main(String[] args) {
        ArrayList<Customer> users = CustomerDao.getAllCusotmers();

        for (Customer c : users) {
            System.out.println(c.getCid() + " " + c.getFirstname());
        }

    }
}
