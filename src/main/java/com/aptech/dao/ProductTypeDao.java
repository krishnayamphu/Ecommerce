package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductTypeDao {
    //get all product types
    public static ArrayList<ProductType> getAllProductTypes() {
        ArrayList<ProductType> all_product_type = new ArrayList<>();
        Connection cn = ConnectDB.connect();
        String sql = "SELECT * FROM product_types";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("product_type_id"));
                String name = rs.getString("name");
                String description = rs.getString("description");
                String date = rs.getString("created_at");

                ProductType productType = new ProductType();
                productType.setId(id);
                productType.setName(name);
                productType.setDescription(description);
                productType.setCreatedAt(date);
                all_product_type.add(productType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_product_type;
    }
}
