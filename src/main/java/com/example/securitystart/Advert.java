package com.example.securitystart;

public class Advert {

    private String name;
    private int price;
    private String description;
    private String url;

    public Advert(String name, int price, String description, String url) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.url = url;
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
