package com.aptech.controllers;

import com.aptech.dao.ProductDao;
import com.aptech.dao.ShoppingCartDao;
import com.aptech.models.Product;
import com.aptech.models.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShoppingCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        int order_status_code = 0;
        int qty = 1;

        ShoppingCart cart = new ShoppingCart();
        cart.setCid(cid);
        cart.setPid(pid);
        cart.setOrderStatusCode(order_status_code);
        cart.setQuantity(qty);

        ShoppingCartDao.saveShoppingCartItem(cart);
        System.out.println("added to cart");
        response.sendRedirect("shopping-cart?cid=" + cid + "&&pid=" + pid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        ArrayList<ShoppingCart> all_cart_items = ShoppingCartDao.getAllShoppingCartItmes(cid);
        ArrayList<Product> singleProduct = ProductDao.getSingleProduct(pid);

        request.setAttribute("all_cart_items", all_cart_items);
        request.setAttribute("singleProduct", singleProduct);

        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
    }
}
