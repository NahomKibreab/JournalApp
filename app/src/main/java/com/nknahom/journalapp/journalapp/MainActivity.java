package com.nknahom.journalapp.journalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nknahom.journalapp.journalapp.User_Account.CreateNewAccount;
import com.nknahom.journalapp.journalapp.User_Account.loginActivity;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference fUsersDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create = findViewById(R.id.create);
        Button login = findViewById(R.id.login);
    }

    public void login(View view) {
        Intent login = new Intent(MainActivity.this, loginActivity.class);
        startActivity(login);
    }

    public void register(View view) {
        Intent login = new Intent(MainActivity.this, CreateNewAccount.class);
        startActivity(login);
    }

}
