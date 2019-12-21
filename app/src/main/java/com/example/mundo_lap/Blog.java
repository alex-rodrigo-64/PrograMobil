package com.example.mundo_lap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Blog extends Fragment {

    DatabaseReference mDatabase;
    FirebaseAuth mAuth;

    Button irHome;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.blog_row,container,false);

        mDatabase.child("items").child("001").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title1);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio1);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image1);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.child("items").child("002").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title2);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio2);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image2);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabase.child("items").child("003").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title3);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio3);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image3);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabase.child("items").child("004").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title4);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio4);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image4);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabase.child("items").child("005").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title5);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio5);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image5);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.child("items").child("006").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title6);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio6);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image6);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.child("items").child("007").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title7);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio7);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image7);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.child("items").child("008").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title8);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio8);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image8);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.child("items").child("009").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title9);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio9);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image9);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.child("items").child("010").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title10);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio10);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image10);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return  view;
    }
}
