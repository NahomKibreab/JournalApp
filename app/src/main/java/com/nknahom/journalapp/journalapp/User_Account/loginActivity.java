package com.nknahom.journalapp.journalapp.User_Account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.nknahom.journalapp.journalapp.MainActivity;
import com.nknahom.journalapp.journalapp.R;

public class loginActivity extends AppCompatActivity {

    EditText inputEmail, inputPass;
    private Button btnLogIn;

    private FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.input_log_email);
        inputPass = (EditText) findViewById(R.id.input_log_pass);
        btnLogIn = (Button) findViewById(R.id.btn_log);

        fAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lEmail = inputEmail.getText().toString().trim();
                String lPass = inputPass.getText().toString().trim();

                if (!TextUtils.isEmpty(lEmail) && !TextUtils.isEmpty(lPass)) {
                    logIn(lEmail, lPass);
                }

            }
        });

    }

    private void logIn(String email, String password) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging in, please wait...");
        progressDialog.show();

        fAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if (task.isSuccessful()) {

                            Intent mainIntent = new Intent(loginActivity.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();

                            Toast.makeText(loginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(loginActivity.this, "ERROR: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return true;
    }
}
