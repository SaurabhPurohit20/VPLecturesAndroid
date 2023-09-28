package com.example.vplectures.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vplectures.R;

public class SharedPrefsActivity extends AppCompatActivity {
    String PREFS_FILE = "sp_filenm";
    SharedPreferences pref = null;
    SharedPreferences.Editor editor = null;

    Button btn, btnGetName;
    EditText etName;
    TextView tvName;

    CheckBox cbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs);


        pref = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
        editor = pref.edit();

        if (getIntent().getExtras() != null) {
            String name = getIntent().getExtras().getString("name", "-");
            String pass = getIntent().getExtras().getString("pass", "-");

            editor.putString("username", name);
            editor.putString("pass", pass);
            editor.apply();

            Intent i = new Intent();
            i.putExtra("txt", "Name & Password Saved Successfully");
            setResult(RESULT_OK, i);
            finish();
        }

        etName = findViewById(R.id.et_name);
        etName.setText(getName());
        tvName = findViewById(R.id.tv_name);

        btn = findViewById(R.id.btn_add_name);
        btn.setOnClickListener(view -> {
            String name = etName.getText().toString().trim();
            addName(name);
        });

        btnGetName = findViewById(R.id.btn_get_name);
        btnGetName.setOnClickListener(view -> {
            String name = getName();
            tvName.setText(name);
        });

        cbLogin = findViewById(R.id.cb_login);
        cbLogin.setChecked(getLogin());
        cbLogin.setOnCheckedChangeListener((compoundButton, b) -> {
            setLogin(b);
            //?:
            String str = b ? "Login success" : "Login Removed";
            new AlertDialog.Builder(this)
                    .setTitle("Login").setMessage(str)
                    .create().show();
        });
    }

    void setLogin(boolean value) {
        editor.putBoolean("login", value);
        editor.apply();
    }

    boolean getLogin() {
        return pref.getBoolean("login", false);
    }

    void addName(String name) {//"Android Demo"
//        String[] strs = new String[]{"One", "Two"};
//        Set<String> setOfStrings = new HashSet<>(Arrays.asList(strs));
//        editor.putStringSet("nums", setOfStrings);

        editor.putString("name", name);
        editor.apply();
    }

    String getName() {
        return pref.getString("name", "Not Added Yet");
    }
}