package com.example.vplectures.activities.api.models;

import androidx.annotation.NonNull;

public class PostsModel {
    public int userId, id;
    public String title, body;

    @NonNull
    @Override
    public String toString() {
        return "PostsModel{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public PostsModel(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
