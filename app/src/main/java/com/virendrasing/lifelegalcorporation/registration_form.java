package com.virendrasing.lifelegalcorporation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.virendrasing.lifelegalcorporation.Classes.UserDetail;
import com.virendrasing.lifelegalcorporation.databinding.ActivityRegistrationFormBinding;

import java.util.Map;

public class registration_form extends AppCompatActivity {
    private ActivityRegistrationFormBinding binding;
    private FirebaseFirestore mDatabase;
    private static final int MAX_CHILDREN = 2;
    private long customer_id = 1;
    int refferalid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.orange));
        mDatabase = FirebaseFirestore.getInstance();
        // Increment customer_id
        binding.registrationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String referralId = binding.referralId.getText().toString();
                String name = binding.name.getText().toString();

                mDatabase.collection("user1").document("uid1").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        DocumentSnapshot documentSnapshot = task.getResult();
                       UserDetail data  = documentSnapshot.toObject(UserDetail.class);

                        Toast.makeText(registration_form.this, data.getAgentId(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}
