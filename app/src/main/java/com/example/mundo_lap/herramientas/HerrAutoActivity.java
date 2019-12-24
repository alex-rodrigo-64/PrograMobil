package com.example.mundo_lap.herramientas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mundo_lap.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class HerrAutoActivity extends AppCompatActivity {
    DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herr_autocad);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        mDatabase.child("Herramientas").child("Autocad").child("001").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x1 = (TextView) findViewById(R.id.post_title1r);
                    x1.setText(mast);
                    TextView x2 = (TextView) findViewById(R.id.post_precio1r);
                    x2.setText(mast2);
                    ImageView x3 = (ImageView) findViewById(R.id.post_image1r);
                    Picasso.get().load(mast3).into(x3);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }
        );
    }
}
