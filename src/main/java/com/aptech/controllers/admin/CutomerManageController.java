package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.dao.CustomerDao;
import com.aptech.models.Admin;
import com.aptech.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CutomerManageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> allCustomers = CustomerDao.getAllCusotmers();
        request.setAttribute("allCustomers", allCustomers);
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }
}
