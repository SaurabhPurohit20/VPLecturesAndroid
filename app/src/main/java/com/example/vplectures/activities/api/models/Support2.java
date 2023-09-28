package com.example.vplectures.activities.api.models;

public class Support2 {
    public String url, text;

    @Override
    public String toString() {
        return "Support {" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                "}\n";
    }

    public Support2(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }
}