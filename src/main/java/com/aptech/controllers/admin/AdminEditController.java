package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdminEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        if (password.equals(cpassword)) {
            Admin admin = new Admin();
            admin.setFirstname(firstname);
            admin.setLastname(lastname);
            admin.setEmail(email);
            admin.setContact(contact);
            admin.setPassword(password);
            admin.setUpdatedAt(timeStamp);
            admin.setId(id);
            boolean status = AdminDao.updateAdmin(admin);
            PrintWriter pw = response.getWriter();
            pw.print(status);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        ArrayList<Admin> adminuser= AdminDao.getSingleAdminUser(id);

        request.setAttribute("adminuser",adminuser);
        request.getRequestDispatcher("auth/edit.jsp").forward(request,response);
    }
}
