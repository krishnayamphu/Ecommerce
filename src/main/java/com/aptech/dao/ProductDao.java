package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.Admin;
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

    //get single product
    public static ArrayList<Product> getSingleProduct(int pid) {
        ArrayList<Product> singleProduct = new ArrayList<>();
        Connection cn = ConnectDB.connect();
        String sql = "SELECT * FROM product WHERE hide=0 AND product_id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, pid);
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
                singleProduct.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singleProduct;
    }

    //create product item
    public static int saveProduct(Product product) {
        int status = 0;
        Connection cn = ConnectDB.connect();
        String sql = "INSERT INTO product (product_type_id,name,mrp_price,actual_price,color,size,image,hide,short_description,long_description) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, product.getProductTypeId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getMrpPrice());
            ps.setString(4, product.getActualPrice());
            ps.setString(5, product.getColor());
            ps.setString(6, product.getSize());
            ps.setString(7, product.getImage());
            ps.setInt(8, product.getHide());
            ps.setString(9, product.getShortDescription());
            ps.setString(10, product.getLongDescription());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

}
