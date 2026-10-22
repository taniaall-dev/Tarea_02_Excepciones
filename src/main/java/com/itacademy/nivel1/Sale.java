package com.itacademy.nivel1;
import java.util.List;

public class Sale {

    private List<Product> products;
    private double totalPrice;

    public Sale (List<Product> products){
        this.products = products;
    }

    public double calculateTotal() throws EmptySaleException{
        if (products != null && !products.isEmpty()){
            totalPrice = 0;
            for(Product product : products){
                totalPrice += product.getPrice();
            }
        }else{
            throw new EmptySaleException();
        }
        return totalPrice;
    }
}
