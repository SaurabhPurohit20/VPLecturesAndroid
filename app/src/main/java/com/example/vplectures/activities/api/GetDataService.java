package com.example.vplectures.activities.api;

import com.example.vplectures.activities.api.models.Employees;
import com.example.vplectures.activities.api.models.Login;
import com.example.vplectures.activities.api.models.MyLogin;
import com.example.vplectures.activities.api.models.MyLoginParams;
import com.example.vplectures.activities.api.models.PostsModel;
import com.example.vplectures.activities.api.models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetDataService {
    //https://jsonplaceholder.typicode.com/posts
    @GET("/posts")
    Call<List<PostsModel>> getAllPhotos();

    @GET("/api/users?page=2")
    Call<Users> getUsers();

    @POST("/api/login")
    Call<Login> login(@Body Login2 login);

    @GET("/api/employees")
    Call<Employees> getEmployees(@Query("name") String name, @Query("size") String size);


    @POST("/api/login")
    Call<MyLogin> myLogin(@Body MyLoginParams login);
}

class Login2 {
    String email, password;

    public Login2(String email, String password) {
        this.email = email;
        this.password = password;
    }
}