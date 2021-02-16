package com.example.items;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowUsersActivity extends AppCompatActivity {

    private TextView nameTextView, cityTextView, ageTextView, genderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        initWidgets();

        String name = getIntent().getStringExtra("name");
        String city = getIntent().getStringExtra("city");
        String age = getIntent().getStringExtra("age");
        String gender = getIntent().getStringExtra("gender");

        nameTextView.setText(name);
        cityTextView.setText(city);
        ageTextView.setText(age);
        genderTextView.setText(gender);

    }

    private void initWidgets(){

        nameTextView = findViewById(R.id.personName);
        cityTextView = findViewById(R.id.personCity);
        ageTextView = findViewById(R.id.personAge);
        genderTextView = findViewById(R.id.personGender);

    }
}