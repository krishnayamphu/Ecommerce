package com.aptech.dao;

import com.aptech.dbhelper.ConnectDB;
import com.aptech.models.Admin;
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

    //create product type
    public static int saveProductType(ProductType productType) {
        int status = 0;
        Connection cn = ConnectDB.connect();
        String sql = "INSERT INTO product_types (name,description) VALUES(?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, productType.getName());
            ps.setString(2, productType.getDescription());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    //update product type
    public static boolean updateProductType(ProductType productType) {
        boolean bool = false;
        Connection cn = ConnectDB.connect();
        String sql = "UPDATE product_types SET name=?,description=?,updated_at=? WHERE id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, productType.getName());
            ps.setString(2, productType.getDescription());
            ps.setString(3, productType.getUpdatedAt());
            ps.setInt(4, productType.getId());
            int status = ps.executeUpdate();
            if (status == 1) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    //delete product type
    public static boolean deleteProductType(int id) {
        boolean bool = false;
        Connection cn = ConnectDB.connect();
        String sql = "DELETE FROM product_types WHERE product_type_id=?";
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
