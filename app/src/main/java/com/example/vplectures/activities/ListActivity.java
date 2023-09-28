package com.example.vplectures.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vplectures.R;
import com.example.vplectures.activities.api.GetResponseActivity;
import com.example.vplectures.activities.api.RetrofitApiActivity;

public class ListActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String PREFS_FILE = "sp_filenm";
        SharedPreferences settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        boolean isLogin = settings.getBoolean("login", false);

        if (isLogin) {
            startActivity(new Intent(getApplicationContext(), SharedPrefsActivity.class));
            finish();
        }

        lv = findViewById(R.id.list);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i) {
                    case 0:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), MultiViewsActivity.class);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), IntentsActivity.class);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), LifecycleActivity.class);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), SharedPrefsActivity.class);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), SharedPref2Activity.class);
                        break;
                    case 6:
                        intent = new Intent(getApplicationContext(), CustomListViewActivity.class);
                        break;
                    case 7:
                        intent = new Intent(getApplicationContext(), RecyclerviewActivity.class);
                        break;
                    case 8:
                        intent = new Intent(getApplicationContext(), RvWithVbActivity.class);
                        break;
                    case 9:
                        intent = new Intent(getApplicationContext(), ShimmerActivity.class);
                        break;
                    case 10:
                        intent = new Intent(getApplicationContext(), RetrofitApiActivity.class);
                        break;
                    case 11:
                        intent = new Intent(getApplicationContext(), GetResponseActivity.class);
                        break;
                }

                if (intent != null) startActivity(intent);
            }
        });
    }
}