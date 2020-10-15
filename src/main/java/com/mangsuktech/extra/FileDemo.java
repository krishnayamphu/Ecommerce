package com.mangsuktech.extra;

import com.mangsuktech.dao.ShoppingCartDao;
import com.mangsuktech.models.CartItem;

import java.util.ArrayList;

public class FileDemo {
    public static void main(String[] args) {

        ArrayList<CartItem> all = ShoppingCartDao.getAllShoppingCartItmes(1);
        for (CartItem item : all) {
            System.out.println(item.getPid() + ", " + item.getName() + ", " + item.getPrice() + ", " + item.getQuantity());
        }
    }
}
