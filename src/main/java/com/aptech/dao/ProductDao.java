package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.Product;
import com.aptech.models.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
    //get latest top 6 products
    public static ArrayList<Product> getLatestProducts() {
        ArrayList<Product> latestProducts = new ArrayList<>();
        Connection cn = ConnectDB.connect();
        String sql = "SELECT * FROM product WHERE hide=0 ORDER BY product_id DESC LIMIT 6";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("product_id"));
                int ptid = Integer.parseInt(rs.getString("product_type_id"));
                String name = rs.getString("name");
                String mrpPrice = rs.getString("mrp_price");
                String actPrice = rs.getString("actual_price");
                String color = rs.getString("color");
                String size = rs.getString("size");
                String image = rs.getString("image");
                int hide = Integer.parseInt(rs.getString("hide"));
                String shortDesc = rs.getString("short_description");
                String longDescription = rs.getString("long_description");
                String date = rs.getString("created_at");

                Product product = new Product();
                product.setId(id);
                product.setProductTypeId(ptid);
                product.setName(name);
                product.setMrpPrice(mrpPrice);
                product.setActualPrice(actPrice);
                product.setColor(color);
                product.setSize(size);
                product.setImage(image);
                product.setHide(hide);
                product.setShortDescription(shortDesc);
                product.setLongDescription(longDescription);
                product.setCreatedAt(date);
                latestProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return latestProducts;
    }

}
