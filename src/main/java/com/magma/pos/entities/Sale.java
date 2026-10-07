package com.magma.pos.entities;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private int id;
    private Customer customer;
    private List<SaleItem> items;

    public Sale(int id, Customer customer){
        this.id=id;
        this.customer=customer;
        this.items=new ArrayList<>();
    }
    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            return;
        }
        for (SaleItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.addquantity(quantity);
                return;
            }
        }
        SaleItem item = new SaleItem(product, quantity);
        items.add(item);
    }
    public double getTotal(){
        double total=0;
        for(SaleItem item :items){
            total+=item.getSubtotal();
        }
        return total ;
    }
    public List<SaleItem> getItems() {
        return items;
    }

}
