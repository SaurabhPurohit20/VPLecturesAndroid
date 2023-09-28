package com.example.vplectures.activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vplectures.databinding.ActivitySharedPref3Binding;

public class SharedPref2Activity extends AppCompatActivity {
    ActivitySharedPref3Binding binding;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharedPref3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pref = getSharedPreferences("sp_filenm", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
        loadNamePasswd();

        ActivityResultLauncher<Intent> startActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    String res = result.getData().getExtras().getString("txt");
                    Toast.makeText(this, "Result: " + res, Toast.LENGTH_SHORT).show();
                    loadNamePasswd();
                });

        binding.btnLogin.setOnClickListener(view -> {
            String name = binding.etName.getText().toString(),
                    pass = binding.etPasswd.getText().toString();

            Intent iSharedPref = new Intent(this, SharedPrefsActivity.class);
            iSharedPref.putExtra("name", name);
            iSharedPref.putExtra("pass", pass);
            startActivityLauncher.launch(iSharedPref);
        });
    }

    void loadNamePasswd() {
        String n = pref.getString("username", "N/A"),
                p = pref.getString("pass", "N/A");

        binding.tvResult.setText("Name: " + n + "\nPassword: " + p);
    }
}