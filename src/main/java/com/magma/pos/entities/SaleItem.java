package com.magma.pos.entities;

public class SaleItem {
    private Product product;
    private int quantity;
    private double unitPrice;

    public SaleItem(Product product,int quantity, double unitPrice){
        this.product=product;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
    }
    public Product getProduct(){
        return product;
    }
    public  int getQuantity(){
        return quantity;
    }
    public int getUnitPrice(){
        return unitPrice;
    }
    public double getSubtotal(){
        return quantity*unitPrice;
    }

}

