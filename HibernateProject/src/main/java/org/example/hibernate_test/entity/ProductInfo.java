package org.example.hibernate_test.entity;

import java.util.ArrayList;

public class ProductInfo {
    ProductInfo info = new ProductInfo();
   // info

    interface ProductChecks {
        boolean check(Product p);
    }
    ProductInfo productInfo = new ProductInfo();



    void testProduct(ArrayList<Product> alproducts, ProductChecks cs) {
        for (Product p : alproducts) {
            if (cs.check(p)) {
                System.out.println(p);
            }
        }
    }
}


