package com.mangsuktech.controllers.admin;

import com.mangsuktech.dao.ProductTypeDao;
import com.mangsuktech.models.ProductType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductTypeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String desc = request.getParameter("description");

        ProductType productType = new ProductType();
        productType.setName(name);
        productType.setDescription(desc);
        ProductTypeDao.saveProductType(productType);

        response.sendRedirect("http://localhost:8080/ecommerce/admin/product-type");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ProductType> allProductTypes = ProductTypeDao.getAllProductTypes();
        request.setAttribute("allProductTypes", allProductTypes);
        request.getRequestDispatcher("producttype/index.jsp").forward(request, response);
    }
}
