package com.example.vplectures.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vplectures.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class LifecycleActivity extends AppCompatActivity {
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();
        String txt = tv.getText().toString() + "onCreate()";
        tv.setText(txt);
    }

    @Override
    protected void onStart() {
        super.onStart();

//        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();

        String txt = tv.getText().toString() + "\nonStart()";
        tv.setText(txt);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String txt = tv.getText().toString() + "\nonResume()";
        tv.setText(txt);

//        new MaterialAlertDialogBuilder(this)
//                .setTitle("Test").setMessage("Android Dialog").create().show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        String txt = tv.getText().toString() + "\nonPause()";
        tv.setText(txt);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        String txt = tv.getText().toString() + "\nonPause()";

    }

    @Override
    protected void onStop() {
        super.onStop();


        String txt = tv.getText().toString() + "\nonStop()";
        tv.setText(txt);
    }
}