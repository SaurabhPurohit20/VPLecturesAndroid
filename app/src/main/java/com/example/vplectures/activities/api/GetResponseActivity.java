package com.example.vplectures.activities.api;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vplectures.activities.api.models.Employees;
import com.example.vplectures.activities.api.models.Login;
import com.example.vplectures.activities.api.models.MyLogin;
import com.example.vplectures.activities.api.models.MyLoginParams;
import com.example.vplectures.activities.api.models.Users;
import com.example.vplectures.databinding.ActivityGetResponseBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetResponseActivity extends AppCompatActivity {
    ActivityGetResponseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetResponseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(view -> postLoginCall());

        binding.btnGetEmp.setOnClickListener(view -> getEmployees());

        binding.btnGetCall.setOnClickListener(view -> getCall());

        binding.btnPostCall.setOnClickListener(view -> postCall());
    }

    void postCall() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance2().create(GetDataService.class);
        Call<Login> call = service.login(new Login2("eve.holt@reqres.in", "cityslicka"));
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(@NonNull Call<Login> call, @NonNull Response<Login> response) {
                if (response.body() != null) {
                    Login r = response.body();
                    binding.tv.setText(r.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Login> call, @NonNull Throwable t) {
                Toast.makeText(GetResponseActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void postLoginCall() {
        String name = binding.etName.getText().toString().trim(),
                pass = binding.etSize.getText().toString().trim();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance3().create(GetDataService.class);
        Call<MyLogin> call = service.myLogin(new MyLoginParams(name, pass));
        call.enqueue(new Callback<MyLogin>() {
            @Override
            public void onResponse(@NonNull Call<MyLogin> call, @NonNull Response<MyLogin> response) {
                if (response.body() != null) {
                    MyLogin r = response.body();
                    binding.tv.setText(r.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<MyLogin> call, @NonNull Throwable t) {
                Toast.makeText(GetResponseActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void getCall() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance2().create(GetDataService.class);
        Call<Users> call = service.getUsers();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(@NonNull Call<Users> call, @NonNull Response<Users> response) {
                if (response.body() != null) {
                    Users r = response.body();

//                    int page = r.getPage(),
//                            per_page = r.getPer_page(),
//                            total = r.getTotal(),
//                            total_pages = r.getTotal_pages();
//                    List<Data> data = r.getData();
//                    Support2 support = r.getSupport();
//
//                    String txt = "Page: " + page + "\nPer Page" + per_page + "Total: " + total + "\nTotal_pages: " + total_pages +
//                            "\n\nData: " + data.toString() +
//                            "\n\nSupport: " + support.toString();

                    binding.tv.setText(r.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Users> call, @NonNull Throwable t) {
                Toast.makeText(GetResponseActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void getEmployees() {
        String name = binding.etName.getText().toString().trim(),
                size = binding.etSize.getText().toString().trim();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance3().create(GetDataService.class);
        Call<Employees> call = service.getEmployees(name, size);
        call.enqueue(new Callback<Employees>() {
            @Override
            public void onResponse(@NonNull Call<Employees> call, @NonNull Response<Employees> response) {
                if (response.body() != null) {
                    Employees r = response.body();
                    binding.tv.setText(r.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Employees> call, @NonNull Throwable t) {
                Toast.makeText(GetResponseActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}