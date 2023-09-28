package com.example.vplectures.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vplectures.R;

public class Intents2Activity extends AppCompatActivity {
    TextView tvId;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents2);

        if (getIntent().getExtras() != null) {
            int id = getIntent().getExtras().getInt("id", 0);
            double d = getIntent().getExtras().getDouble("double", 0.5);
            String name = getIntent().getExtras().getString("name", "Name not found");

            tvId = findViewById(R.id.tv_id);
            String idStr = id + "";
            tvId.setText("ID: " + idStr + " Name: " + name + " \nDouble: " + d);
        }

        btn = findViewById(R.id.btn_result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("res", "From second activity result");
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}