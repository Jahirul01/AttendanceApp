package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminSignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText emailEt,passwordEt;
    String email,password;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);
        emailEt = findViewById(R.id.emailSignUpAdmin);
        passwordEt = findViewById(R.id.passwordSignUpAdmin);
        submitBtn = findViewById(R.id.submitSignUpAdmin);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailEt.getText().toString().trim();
                password = passwordEt.getText().toString().trim();
                mAuth = FirebaseAuth.getInstance();
                Toast.makeText(AdminSignUp.this,"Submit button Clicked",Toast.LENGTH_SHORT).show();
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(AdminSignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(AdminSignUp.this,"Sign Up Successful",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(AdminSignUp.this,"Authentication failed", Toast.LENGTH_SHORT).show();
                                }
                            }
            });
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();

        }
}