package com.magma.pos.entities;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(){}
    public Product(int id,String name,double price,int quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setPrice(double price){
        if(price<0){
            System.out.println("prix invalide");
            return;
        }
        this.price=price;
    }
    public void setQuantity(int quantity){
        if(quantity<0){
            System.out.println("quantité invalide");
            return;
        }
        this.quantity=quantity;
    }
    public void addStock(int amount){
        quantity=quantity+amount;
    }
    public boolean removeStock(int amount) {

        if (amount <= 0) {
            System.out.println("La quantité doit être positive");
            return false;
        }

        if (quantity < amount) {
            System.out.println("Stock insuffisant");
            return false;
        }

        quantity = quantity - amount;

        return true;
    }

}
