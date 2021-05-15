package com.example.toddlerteacher;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toddlerteacher.databinding.FragmentStatisticsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class StatisticsFragment extends Fragment {



    public StatisticsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentStatisticsBinding binding;
    FirebaseFirestore database;
    User user;
    int grade =0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentStatisticsBinding.inflate(inflater, container, false);
        database = FirebaseFirestore.getInstance();

        Task<DocumentSnapshot> documentSnapshotTask = database.collection("users")
                .document(FirebaseAuth.getInstance().getUid())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        user = documentSnapshot.toObject(User.class);
                       // grade = (int) user.getCoins();

                        if(user.getCoins()== 25){
                            binding.currentCoins.setText("You will be graded here! Good luck!");
                            binding.strength.setText("Kudos to you for trying out the app!");
                            binding.weakness.setText("No weaknesses recorded");
                            binding.repeated.setText("No Levels repeated");
                        }
                        else if (user.getCoins() < 100) {
                            binding.currentCoins.setText("You have a D. You got this!");
                            binding.strength.setText("You are determined to win the game. Keep up with the numbers!");
                            binding.weakness.setText("Keep working on the alphabets, you got this!");
                            binding.repeated.setText("No Levels repeated");
                        } else if (user.getCoins() < 200) {
                            binding.currentCoins.setText("You have a C. You got this!");
                            binding.strength.setText("You are getting closer to your goals. Good job with the alphabets!");
                            binding.weakness.setText("Keep working on the trivia, you got this!");
                            binding.repeated.setText("Level 1 repeated");
                        } else if (user.getCoins() < 300) {
                            binding.currentCoins.setText("You have a B. You got this!");
                            binding.strength.setText("You are killing the trivia. Kudos to you!");
                            binding.weakness.setText("Keep working on the trivia, you got this!");
                            binding.repeated.setText("Level 1 and 2 repeated");
                        } else {
                            binding.currentCoins.setText("Congratulations! You have an A");
                            binding.strength.setText("You have mastered the game. Your calculation skills are amazing!");
                            binding.weakness.setText("You have successfully eliminated all your weaknesses, We're proud of you!");
                            binding.repeated.setText("Level 1, 2 and 3 repeated");
                        }


                    }
                });


        return binding.getRoot();
    }
}