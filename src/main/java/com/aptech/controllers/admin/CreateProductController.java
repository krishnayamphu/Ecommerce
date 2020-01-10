package com.aptech.controllers.admin;

import com.aptech.dao.ProductDao;
import com.aptech.dao.ProductTypeDao;
import com.aptech.mediahelper.MediaHelper;
import com.aptech.models.Product;
import com.aptech.models.ProductType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CreateProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String mrp = request.getParameter("mrp_price");
        String act = request.getParameter("actual_price");
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        String image = request.getParameter("imageName");
        String short_desc = request.getParameter("short_desc");
        String long_desc = request.getParameter("long_desc");
        int hide = Integer.parseInt(request.getParameter("hide"));
        int product_type_id = Integer.parseInt(request.getParameter("product_type_id"));
        Product product = new Product();
        product.setName(name);
        product.setMrpPrice(mrp);
        product.setActualPrice(act);
        product.setColor(color);
        product.setSize(size);
        product.setImage(image);
        product.setShortDescription(short_desc);
        product.setLongDescription(long_desc);
        product.setHide(hide);
        product.setProductTypeId(product_type_id);

        ProductDao.saveProduct(product);

        response.sendRedirect("products");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ProductType> allProductTypes = ProductTypeDao.getAllProductTypes();
        ArrayList<String> allMedia = MediaHelper.getMediaList();

        request.setAttribute("allProductTypes", allProductTypes);
        request.setAttribute("allMedia", allMedia);
        request.getRequestDispatcher("products/create.jsp").forward(request, response);
    }
}
