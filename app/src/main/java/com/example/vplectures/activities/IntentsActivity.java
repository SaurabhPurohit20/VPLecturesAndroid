package com.example.vplectures.activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vplectures.R;

public class IntentsActivity extends AppCompatActivity {
    Button btnOpenLay, btnImplicit, btnSendMail, btnOpenActivity, btnSAR, btnSAR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        btnOpenLay = findViewById(R.id.btn_open_layouts);
        btnImplicit = findViewById(R.id.btn_implicit);
        btnSendMail = findViewById(R.id.btn_implict_send_mail);

        btnSAR = findViewById(R.id.btn_start_result);
        btnSAR.setOnClickListener(view -> {
            Intent intent = new Intent(this, Intents2Activity.class);
            startActivityForResult(intent, 1);
        });
        
        ActivityResultLauncher<Intent> startActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    String res = result.getData().getExtras().getString("res");
                    Toast.makeText(this, "Result: " + res, Toast.LENGTH_SHORT).show();
                });
        btnSAR2 = findViewById(R.id.btn_start_result2);
        btnSAR2.setOnClickListener(view -> {
            Intent intent = new Intent(this, Intents2Activity.class);
            startActivityLauncher.launch(intent);
        });

        btnOpenActivity = findViewById(R.id.btn_pass_values);
        btnOpenActivity.setOnClickListener(view -> {
            Intent i = new Intent(this, Intents2Activity.class);
            i.putExtra("id", 2308);
            double d = 2308.054;
            i.putExtra("double", d);
//            i.putExtra("name", "Android");
            startActivity(i);
        });

        btnOpenLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LayoutsActivity.class);
                startActivity(i);
            }
        });

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://sanglisoftware.com");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });


        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9011392128")); //Replace with valid phone number. Remember to add the
                //tel: prefix, otherwise it will crash.
                startActivity(intent);

//                // Compile a Uri with the 'mailto' schema
//                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
//                        "mailto", "johndoe@example.com", null));
//// Subject
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello World!");
//// Body of email
//                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi! I am sending you a test email.");
//// File attachment
////                emailIntent.putExtra(Intent.EXTRA_STREAM, attachedFileUri);
//// Check if the device has an email client
//                if (emailIntent.resolveActivity(getPackageManager()) != null) {
//                    // Prompt the user to select a mail app
//                    startActivity(Intent.createChooser(emailIntent, "Choose your mail application"));
//                } else {
//                    // Inform the user that no email clients are installed or provide an alternative
//                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String res = data.getExtras().getString("res");
            Toast.makeText(this, "Result: " + res, Toast.LENGTH_SHORT).show();
        }
    }
}