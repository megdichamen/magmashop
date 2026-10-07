package com.magma.pos.entities;

public class SaleItem {
    private Product product;
    private int quantity;
    private double unitPrice;

    public SaleItem(Product product,int quantity){
        this.product=product;
        this.quantity=quantity;
        this.unitPrice=product.getPrice();
    }
    public Product getProduct(){
        return product;
    }
    public  int getQuantity(){
        return quantity;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public double getSubtotal(){
        return quantity*unitPrice;
    }
    public void addquantity(int quantity){
        this.quantity=this.quantity+quantity;
    }


}

