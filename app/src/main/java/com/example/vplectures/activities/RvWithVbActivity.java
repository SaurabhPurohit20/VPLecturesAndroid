package com.example.vplectures.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.vplectures.R;
import com.example.vplectures.adapters.RvWithVbAdapter;
import com.example.vplectures.databinding.ActivityRvWithVbBinding;
import com.example.vplectures.models.RvVbModel;

import java.util.ArrayList;

public class RvWithVbActivity extends AppCompatActivity {
    ActivityRvWithVbBinding binding;
    RvWithVbAdapter rvWithVbAdapter;
    ArrayList<RvVbModel> l = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRvWithVbBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for (int i = 1; i < 50; i++) {
            l.add(new RvVbModel("Title " + i, "Subtitle " + i, "Price" + i));
        }

        rvWithVbAdapter = new RvWithVbAdapter(l, this);
        binding.rv.setAdapter(rvWithVbAdapter);
        
    }
}