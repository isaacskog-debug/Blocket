package com.example.securitystart;

import org.springframework.boot.convert.DataSizeUnit;
//import javax.validation.constraints.Size;

public class Advert {


    private Long id;
    @Size(min=1, max=30)
    private String name;
    @Size(min=1, max=30)
    private int price;
    @Size(min=25, max=250)
    private String description;
    private String url;
    @Size(min=1, max=10)
    private String currency;
    private int count;


    public Advert(Long id, String name, int price, String currency, String description, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.description = description;
        this.url = url;
        this.count = 1;

    }

    public Advert(){

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Selected item: " + name + " Price: " + (price *count )+" "+currency+" Amount: " + count;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
