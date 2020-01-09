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
//    public static ArrayList<ShoppingCart> getAllShoppingCartItmes() {
//        ArrayList<ShoppingCart> all_shopping_carts = new ArrayList<>();
//        Connection cn = ConnectDB.connect();
//        String sql = "SELECT * FROM shopping_carts";
//        try {
//            PreparedStatement ps = cn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = Integer.parseInt(rs.getString("product_type_id"));
//                String name = rs.getString("name");
//                String description = rs.getString("description");
//                String date = rs.getString("created_at");
//
//                ProductType productType = new ProductType();
//                productType.setId(id);
//                productType.setName(name);
//                productType.setDescription(description);
//                productType.setCreatedAt(date);
//                all_shopping_carts.add(productType);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return all_product_type;
//    }

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
