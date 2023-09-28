package com.example.vplectures.models;

public class RvVbModel {
    String title, subtitle, price;

    public RvVbModel(String title, String subtitle, String price) {
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPrice() {
        return price;
    }
}
