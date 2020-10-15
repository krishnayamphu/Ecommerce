package com.mangsuktech.controllers.admin;

import com.mangsuktech.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");//admin@gmail.com
        String password = request.getParameter("password");
        int status = AdminDao.login(email, password);
        PrintWriter pw = response.getWriter();
        if (status == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("dashboard");
        } else {
            String msg="Invalid username or password";
            request.setAttribute("err",msg);
            request.getRequestDispatcher("auth/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("auth/login.jsp").forward(request, response);
    }
}
