package com.example.securitystart;

import javax.persistence.*;
import java.util.Objects;

//import javax.validation.constraints.Size;
@Entity
public class Advert {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Size(min=1, max=30)
    private String name;
    //@Size(min=1, max=30)
    private int price;
    //@Size(min=25, max=250)
    private String description;
    //private String url;
    //@Size(min=1, max=10)
    private String currency;

    private Integer quantity = 1;

    @ManyToOne
    private Owner owner;


    public Advert(Long id, String name, int price, String currency, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.description = description;
        //this.url = url;
        //this.count = 1;
        //this.quantity = 1;

    }

    public Advert(){

    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isNew() {
        return this.id == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {return currency;}

    public void setCurrency(String currency) {this.currency = currency;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
*/
    @Override
    public String toString() {
        return "Selected item: " + name + " Price: " + (price * quantity)+" "+currency+" Amount: " + quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return Objects.equals(name, advert.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
