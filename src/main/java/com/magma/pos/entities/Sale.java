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
    public void addItem(Product product,int quantity){

    }

}
