package com.example.toddlerteacher;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toddlerteacher.databinding.ActivityRegisterUserBinding;
import com.example.toddlerteacher.databinding.FragmentProfileBinding;
import com.example.toddlerteacher.databinding.FragmentTrackingBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.*;


public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match


    FirebaseAuth auth;
    FirebaseFirestore database;
    FirebaseUser user1;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    FragmentProfileBinding binding;


    User user;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        database = FirebaseFirestore.getInstance();


        database.collection("users")
                .document(FirebaseAuth.getInstance().getUid())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.toObject(User.class);
                binding.nameBox.setText(String.valueOf(user.getName()));
                binding.emailBox.setText(String.valueOf(user.getEmail()));
                binding.passBox.setText(String.valueOf(user.getPass()));
                binding.ageBox.setText(String.valueOf(user.getAge()));
                binding.phoneBox.setText(String.valueOf(user.getPhone()));
                binding.countryBox.setText(String.valueOf(user.getCountry()));
                binding.childAgeBox.setText(String.valueOf(user.getChildAge()));
                binding.childNameBox.setText(String.valueOf(user.getChildName()));

            }
        });

        //java.lang.NullPointerException: Attempt to invoke virtual method 'com.google.android.gms.tasks.Task com.google.firebase.auth.FirebaseUser.updateEmail(java.lang.String)' on a null object reference
        /*
        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.nameBox.getText().toString().isEmpty() ||binding.emailBox.getText().toString().isEmpty() ||binding.passBox.getText().toString().isEmpty()
                        ||binding.ageBox.getText().toString().isEmpty() ||binding.phoneBox.getText().toString().isEmpty()||binding.countryBox.getText().toString().isEmpty()
                        ||binding.childAgeBox.getText().toString().isEmpty()||binding.childNameBox.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Some fields are empty", Toast.LENGTH_SHORT).show();
                    return;
                }


                user1.updateEmail(binding.emailBox.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        DocumentReference docRef = database.collection("users")
                                .document(FirebaseAuth.getInstance().getUid());
                        Map<String,Object> edited = new HashMap<>();
                        edited.put("email",binding.emailBox.getText().toString());
                        edited.put("childAge",binding.childAgeBox.getText().toString());
                        edited.put("childName",binding.childNameBox.getText().toString());
                        edited.put("country",binding.countryBox.getText().toString());
                        edited.put("name",binding.nameBox.getText().toString());
                        edited.put("phone",binding.phoneBox.getText().toString());
                        edited.put("age",binding.ageBox.getText().toString());
                        edited.put("pass",binding.passBox.getText().toString());
                        docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>(){
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getActivity(),"Profile Updated", Toast.LENGTH_SHORT).show();
                            }
                        });

                        Toast.makeText(getActivity(), "Email has been changed", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener(){
                    @Override
                    public void onFailure(@NonNull Exception e){
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });




            }
        }); */





        return binding.getRoot();// Inflate the layout for this fragment


    }
}