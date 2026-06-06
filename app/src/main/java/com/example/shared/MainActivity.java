package com.example.shared;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Klucze do SharedPreferences
    private static final String PREFS_NAME = "MojePref";
    private static final String KLUCZ_IMIE = "imie";
    private static final String KLUCZ_CHECKBOX = "checkbox";

    EditText editText;
    CheckBox checkBox;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextImie);
        checkBox = findViewById(R.id.checkBoxSzczesliwy);
        button  = findViewById(R.id.buttonZapisz);


        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String zapisaneImie = prefs.getString(KLUCZ_IMIE, "");
        boolean zapisanyCheckbox = prefs.getBoolean(KLUCZ_CHECKBOX, false);

        editText.setText(zapisaneImie);
        checkBox.setChecked(zapisanyCheckbox);


        button.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(KLUCZ_IMIE, editText.getText().toString());
            editor.putBoolean(KLUCZ_CHECKBOX, checkBox.isChecked());
            editor.apply();
        });
    }
}