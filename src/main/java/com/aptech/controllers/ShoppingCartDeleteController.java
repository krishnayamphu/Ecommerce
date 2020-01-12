package com.aptech.controllers;

import com.aptech.dao.ShoppingCartDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShoppingCartDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        if (ShoppingCartDao.deleteShoppingCartItem(pid)) {
            response.sendRedirect("/ecommerce/shopping-cart?cid=1");
        } else {
            //error message
        }
        System.out.println(pid + " is deleted");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
