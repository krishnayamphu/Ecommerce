package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String email=request.getParameter("email");
        String contact=request.getParameter("contact");
        String password=request.getParameter("password");
        String cpassword=request.getParameter("cpassword");

        if(password.equals(cpassword)){

            int status=AdminDao.saveAdmin(firstname,lastname,password,email,contact);
            PrintWriter pw=response.getWriter();
            pw.print(status);
//            pw.print(firstname+" "+ lastname+"
//           "+email+" "+contact+" "+password+" "+cpassword);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("auth/register.jsp").forward(request,response);
    }
}
