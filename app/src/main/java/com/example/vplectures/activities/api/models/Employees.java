package com.example.vplectures.activities.api.models;

import java.util.List;

public class Employees {
    String status, message;
    List<EmpData> data;

    @Override
    public String toString() {
        return "Employees{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
