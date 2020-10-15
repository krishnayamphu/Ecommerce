package com.mangsuktech.controllers;

import com.mangsuktech.dao.ProductDao;
import com.mangsuktech.models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> latestProduct = ProductDao.getLatestProducts();
        request.setAttribute("latestProduct", latestProduct);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
