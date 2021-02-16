package com.example.items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.items.database.DatabaseClass;
import com.example.items.model.UserModel;
import com.example.items.viewmodel.UserViewModel;

public class GetDataActivity extends AppCompatActivity {

    private EditText nameEditText, cityEditText, ageEditText, genderEditText;
    private Button saveButton;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        initWidgets();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();

            }
        });

    }

    private void initWidgets(){

        nameEditText = findViewById(R.id.nameEditText);
        cityEditText = findViewById(R.id.cityEditText);
        ageEditText = findViewById(R.id.ageEditText);
        genderEditText = findViewById(R.id.genderEditText);
        saveButton = findViewById(R.id.saveButton);

    }

    private void saveData(){

        String name = nameEditText.getText().toString();
        String city = cityEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();

        if(!name.trim().isEmpty()){

            if(!city.trim().isEmpty()){

                if (!age.trim().isEmpty()){

                    if(!gender.trim().isEmpty()){

                        UserModel model = new UserModel(name, city, age, gender);

                        ViewModelStoreOwner viewModelStoreOwner = this;

                        userViewModel = new ViewModelProvider(viewModelStoreOwner).get(UserViewModel.class);
                        userViewModel.insert(model);

                        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(mainIntent);
                        finish();

                    }else{

                        Toast.makeText(this, "Gender field cannot be empty!", Toast.LENGTH_SHORT).show();

                    }

                }else{

                    Toast.makeText(this, "Age field cannot be empty!", Toast.LENGTH_SHORT).show();

                }

            }else{

                Toast.makeText(this, "City field cannot be empty!", Toast.LENGTH_SHORT).show();

            }

        }else{

            Toast.makeText(this, "Name field cannot be empty!", Toast.LENGTH_SHORT).show();

        }

    }

}