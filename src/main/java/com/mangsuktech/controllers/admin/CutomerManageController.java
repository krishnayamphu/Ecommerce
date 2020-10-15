package com.mangsuktech.controllers.admin;

import com.mangsuktech.dao.CustomerDao;
import com.mangsuktech.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CutomerManageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        int cid = Integer.parseInt(request.getParameter("id"));
        int active = Integer.parseInt(request.getParameter("active"));
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Customer customer = new Customer();
        customer.setCid(cid);
        customer.setActive(active);
        customer.setUpdatedAt(timeStamp);

        CustomerDao.updateActiveStatus(customer);
        response.sendRedirect("customer");
//        pw.print(cid+" "+active);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> allCustomers = CustomerDao.getAllCusotmers();
        request.setAttribute("allCustomers", allCustomers);
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }
}
