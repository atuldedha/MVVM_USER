package com.example.items.register;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.items.MainActivity;
import com.example.items.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FrameLayout mainFrameLayout;

    public boolean setSignup=false;

    private FirebaseAuth firebaseAuth;

    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mainFrameLayout=findViewById(R.id.mainFrameLayout);

        firebaseAuth= FirebaseAuth.getInstance();

        currentUser= firebaseAuth.getCurrentUser();


    }

    @Override
    protected void onStart() {
        super.onStart();

        if(currentUser == null){

            setFragment(new SigninFragment());

        }else{

            Intent start = new Intent(this, MainActivity.class);
            startActivity(start);
            finish();

        }

    }

    private void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(mainFrameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }

}