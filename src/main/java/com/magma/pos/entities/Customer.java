package com.magma.pos.entities;

public class Customer {
    private int id;
    private String name;
    private String email;
    private int loyaltyPoints;

    public Customer(){}
    public Customer(int id,String name,String email,int loyaltyPoints){
        this.id=id;
        setName(name);
        setEmail(email);
        setLoyaltyPoints(loyaltyPoints);
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public int getLoyaltyPoints(){
        return loyaltyPoints;
    }
    public void setName(String name){
        if(name == null || name.trim().isEmpty()){
            System.out.println("Le nom est vide");
            return;
        }
        this.name=name;
    }
    public void setEmail(String email){
        if(email == null || email.trim().isEmpty()){
            System.out.println("Email vide");
            return;
        }
        this.email=email;
    }
    public void setLoyaltyPoints(int loyaltyPoints){
        if(loyaltyPoints<0){
            System.out.println("poin de loyalte negative");
            return;
        }
        this.loyaltyPoints=loyaltyPoints;
    }
}
