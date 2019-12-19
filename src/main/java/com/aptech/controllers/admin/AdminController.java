package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Admin> adminusers= AdminDao.getAllAdmins();
        request.setAttribute("alladmins",adminusers);
//        PrintWriter pw =response.getWriter();
//        for (Admin a:adminusers ) {
//            pw.println(a.getEmail());
//        }

        request.getRequestDispatcher("admin/admin.jsp").forward(request,response);
    }
}
