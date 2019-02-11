package com.example.test11;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Yemek {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("receipe")
    @Expose
    private String receipe;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceipe() {
        return receipe;
    }

    public void setReceipe(String receipe) {
        this.receipe = receipe;
    }

}