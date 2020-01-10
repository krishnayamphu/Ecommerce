package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.ProductType;
import com.aptech.models.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingCartDao {
    //get all shopping cart items
    public static ArrayList<ShoppingCart> getAllShoppingCartItmes(int customerID) {
        ArrayList<ShoppingCart> all_shopping_carts = new ArrayList<>();
        Connection cn = ConnectDB.connect();
        String sql = "SELECT * FROM shopping_carts WHERE cid=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                int pid = Integer.parseInt(rs.getString("pid"));
                int cid = Integer.parseInt(rs.getString("cid"));
                int order_status_code = Integer.parseInt(rs.getString("order_status_code"));
                int qty = Integer.parseInt(rs.getString("quantity"));

                ShoppingCart cart = new ShoppingCart();
                cart.setId(id);
                cart.setPid(pid);
                cart.setCid(cid);
                cart.setOrderStatusCode(order_status_code);
                cart.setQuantity(qty);
                all_shopping_carts.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_shopping_carts;
    }

    //create shopping cart item
    public static int saveShoppingCartItem(ShoppingCart cart) {
        int status = 0;
        Connection cn = ConnectDB.connect();
        String sql = "INSERT INTO shopping_carts (cid,pid,order_status_code,quantity) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, cart.getCid());
            ps.setInt(2, cart.getPid());
            ps.setInt(3, cart.getOrderStatusCode());
            ps.setInt(4, cart.getQuantity());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

}
