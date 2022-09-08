package com.example.securitystart;

import org.springframework.stereotype.Repository;

public class Advert {

    private Long id;
    private String name;
    private int price;
    private String description;
    private String url;

    public Advert(Long id, String name, int price, String description, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.url = url;
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

}
