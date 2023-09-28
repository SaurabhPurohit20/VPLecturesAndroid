package com.example.vplectures.activities.api;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vplectures.activities.api.models.PostsModel;
import com.example.vplectures.databinding.ActivityRetrofitApiBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitApiActivity extends AppCompatActivity {
    ActivityRetrofitApiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrofitApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<PostsModel>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostsModel>> call, @NonNull Response<List<PostsModel>> response) {
                PostsAdapter pa = new PostsAdapter(response.body());
                binding.rv.setAdapter(pa);
            }

            @Override
            public void onFailure(@NonNull Call<List<PostsModel>> call, @NonNull Throwable t) {
                Toast.makeText(RetrofitApiActivity.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}