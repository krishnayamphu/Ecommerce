package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.CartItem;
import com.aptech.models.ProductType;
import com.aptech.models.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingCartDao {
    //get all shopping cart items
    public static ArrayList<CartItem> getAllShoppingCartItmes(int customerID) {
        ArrayList<ShoppingCart> all_shopping_carts = new ArrayList<>();
        ArrayList<CartItem> all_items = new ArrayList<>();
        Connection cn = ConnectDB.connect();
//        String sql = "SELECT DISTINCT pid,cid,order_status_code,quantity FROM shopping_carts WHERE cid=?";
        String sql = "select distinct product.product_id, product.name, product.mrp_price,shopping_carts.quantity from product inner join shopping_carts on product.product_id=shopping_carts.pid where shopping_carts.cid=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                int id = Integer.parseInt(rs.getString("id"));
                int pid = Integer.parseInt(rs.getString("product_id"));
//                int cid = Integer.parseInt(rs.getString("cid"));
//                int order_status_code = Integer.parseInt(rs.getString("order_status_code"));
                int qty = Integer.parseInt(rs.getString("quantity"));
                String name = rs.getString("name");
                String price = rs.getString("mrp_price");

//                ShoppingCart cart = new ShoppingCart();
//                cart.setId(id);
//                cart.setPid(pid);
//                cart.setCid(cid);
//                cart.setOrderStatusCode(order_status_code);
//                cart.setQuantity(qty);
//                all_shopping_carts.add(cart);

                CartItem cartItem = new CartItem();
                cartItem.setPid(pid);
                cartItem.setName(name);
                cartItem.setPrice(price);
                cartItem.setQuantity(qty);

                all_items.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_items;
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

    //delete product type
    public static boolean deleteShoppingCartItem(int id) {
        boolean bool = false;
        Connection cn = ConnectDB.connect();
        String sql = "DELETE FROM shopping_carts WHERE pid=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            int status = ps.executeUpdate();
            if (status == 1) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

}
