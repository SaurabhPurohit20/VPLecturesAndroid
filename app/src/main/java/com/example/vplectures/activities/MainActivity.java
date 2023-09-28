package com.example.vplectures.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vplectures.R;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button btnAdd, btnMul;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.et_num1);
        num2 = findViewById(R.id.et_num2);

        btnAdd = findViewById(R.id.btn_add);
        btnMul = findViewById(R.id.btn_mul);

        tvResult = findViewById(R.id.tv_result);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                add(n1, n2);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                mul(n1, n2);
            }
        });
    }

    void add(double n1, double n2) {
        String addition = (n1 + n2) + "";
        tvResult.setText(addition);
    }

    void mul(double n1, double n2) {
        String m = (n1 * n2) + "";
        tvResult.setText(m);
    }
}