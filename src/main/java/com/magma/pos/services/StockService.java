package com.magma.pos.services;
import com.magma.pos.entities.Product;
public class StockService {
    public boolean sellProduct(Product product, int quantity) {
        if (product == null) {
            return false;
        }
        return product.removeStock(quantity);
    }
    public void restockProduct(Product product, int quantity) {
        if (product == null) {
            return;
        }
        product.addStock(quantity);
    }
}
