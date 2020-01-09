package com.aptech.controllers.admin;

import com.aptech.dao.ProductTypeDao;
import com.aptech.mediahelper.MediaHelper;
import com.aptech.models.ProductType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CreateProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ProductType> allProductTypes = ProductTypeDao.getAllProductTypes();
        ArrayList<String> allMedia = MediaHelper.getMediaList();

        request.setAttribute("allProductTypes", allProductTypes);
        request.setAttribute("allMedia", allMedia);
        request.getRequestDispatcher("products/create.jsp").forward(request, response);
    }
}
