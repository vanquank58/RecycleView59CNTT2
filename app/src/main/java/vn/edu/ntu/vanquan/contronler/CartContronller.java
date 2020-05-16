package vn.edu.ntu.vanquan.contronler;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.vanquan.model.Product;

public class CartContronller extends Application implements ICartContronller
{
    List<Product> productsList = new ArrayList<>();
    public  CartContronller()
    {

        productsList.add(new Product("Chuối Sài Gòn",100000,"Tươi ngon giá rẻ"));
        productsList.add(new Product("Xoài lắc",100000,"Tươi ngon giá rẻ"));
        productsList.add(new Product("Nho xanh",2500000,"Tươi ngon giá rẻ"));
        productsList.add(new Product("Táo đỏ",500000,"Tươi ngon giá rẻ"));
        productsList.add(new Product("Cà chua",10000,"Tươi ngon giá rẻ"));
    }
    @Override
    public List<Product> getALlProduct() {
        return null;
    }
}
