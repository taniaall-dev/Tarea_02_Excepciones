package com.itacademy.nivel1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String[] args){

        Product product1 = new Product("Coffee", 1.70);
        Product product2 = new Product("Soup", 8.99);
        Product product3 = new Product("Bread", 1.75);
        Product product4 = new Product("Beef", 12.35);

        List<Product> products =  Arrays.asList(product1, product2, product3, product4);

        Sale sale = new Sale(products);

        try {
            products.get(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nThe price of the products is: " + sale.calculateTotal());
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }
    }
}
