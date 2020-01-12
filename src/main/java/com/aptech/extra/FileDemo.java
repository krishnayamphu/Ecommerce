package com.aptech.extra;

import com.aptech.dao.ShoppingCartDao;
import com.aptech.models.CartItem;
import com.aptech.models.Media;

import java.util.ArrayList;

public class FileDemo {
    public static void main(String[] args) {

        ArrayList<CartItem> all = ShoppingCartDao.getAllShoppingCartItmes(1);
        for (CartItem item : all) {
            System.out.println(item.getPid() + ", " + item.getName() + ", " + item.getPrice() + ", " + item.getQuantity());
        }
    }
}
