package com.example.vplectures.activities.api.models;

import java.util.List;

public class Users {
    int page, per_page, total, total_pages;
    List<Data> data;
    Support2 support;

    @Override
    public String toString() {
        return "Users {" +
                "page=" + page +
                ", per_page=" + per_page +
                ", total=" + total +
                ", total_pages=" + total_pages +
                ", data=" + data.toString() +
                ", support=" + support.toString() +
                "}\n";
    }

    public Users(int page, int per_page, int total, int total_pages, List<Data> data, Support2 support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<Data> getData() {
        return data;
    }

    public Support2 getSupport() {
        return support;
    }
}