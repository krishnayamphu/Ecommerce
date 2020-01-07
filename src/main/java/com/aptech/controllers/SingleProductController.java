package com.aptech.controllers;

import com.aptech.dao.ProductDao;
import com.aptech.models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SingleProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("pid"));
        ArrayList<Product> singleProduct = ProductDao.getSingleProduct(id);
        request.setAttribute("singleProduct", singleProduct);
        request.getRequestDispatcher("single.jsp").forward(request, response);
    }
}
