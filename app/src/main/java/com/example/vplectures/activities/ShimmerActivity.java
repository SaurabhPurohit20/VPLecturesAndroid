package com.example.vplectures.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vplectures.databinding.ActivityShimmerBinding;

public class ShimmerActivity extends AppCompatActivity {
    ActivityShimmerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShimmerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Button 1 to start Shimmer Effect
        binding.button.setOnClickListener(v -> {
            // If auto-start is set to false
            binding.shimmerViewContainer.startShimmer();
        });

        // Button 2 to stop Shimmer Effect
        binding.button2.setOnClickListener(v -> {
            // If auto-start is set to false
            binding.shimmerViewContainer.stopShimmer();
        });
    }
}