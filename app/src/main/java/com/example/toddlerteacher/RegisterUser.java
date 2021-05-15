package com.example.toddlerteacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toddlerteacher.databinding.ActivityRegisterUserBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;



    public class RegisterUser extends AppCompatActivity {

        ActivityRegisterUserBinding binding;
        FirebaseAuth auth;
        FirebaseFirestore database;
        ProgressDialog dialog;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityRegisterUserBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            auth = FirebaseAuth.getInstance();
            database = FirebaseFirestore.getInstance();

            dialog = new ProgressDialog(this);
            dialog.setMessage("Creating new account..");


            binding.registerUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email, pass, name, age, country, childName, childAge,phone;

                    String age1;
                    age1= binding.childAge.getText().toString();

                    email = binding.email.getText().toString();
                    pass = binding.password.getText().toString();
                    phone = binding.textPhone.getText().toString();
                    name = binding.fullName.getText().toString();
                    age = binding.age.getText().toString();
                    country = binding.country.getText().toString();
                    childName = binding.childName.getText().toString();
                    childAge = binding.childAge.getText().toString();


                    if (Integer.parseInt(age1) > 3) {
                        binding.childAge.setError("This app is for toddlers! You must be less than 3 years");
                        binding.childAge.requestFocus();
                        return;
                    }

                    final User user = new User(name, email, pass, phone, age, country, childName, childAge);

                    dialog.show();
                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                String uid = task.getResult().getUser().getUid();

                                database
                                        .collection("users")
                                        .document(uid)
                                        .set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()) {
                                            dialog.dismiss();
                                            startActivity(new Intent(RegisterUser.this, MainActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(RegisterUser.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                dialog.dismiss();
                                Toast.makeText(RegisterUser.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            });


        }
    }