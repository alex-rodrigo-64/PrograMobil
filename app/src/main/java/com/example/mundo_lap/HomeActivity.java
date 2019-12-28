package com.example.mundo_lap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {




    DrawerLayout drawer;
    FirebaseAuth auth;
    DatabaseReference mDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Blog()).commit();
        //cagarCardView();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.my_menu);

        NavigationView navigationView = findViewById(R.id.nav_home);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this, drawer,toolbar,R.string.abrir_navigation_drawner,R.string.cerrar_navigation_drawner);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }


    public void cagarCardView(){

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Blog()).commit();
        mDatabase.child("items").child("001").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("marca").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = findViewById(R.id.post_title1);
                    x.setText(mast);
                    TextView x2 = findViewById(R.id.post_precio1);
                    x2.setText(mast2);
                    ImageView x3 = findViewById(R.id.post_image1);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_cuenta){
            getDataUser();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CuentaFragment()).commit();
        }else{
            if(id == R.id.nav_carrera){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FacultadFragment()).commit();
            }else{
                if(id == R.id.nav_herramienta){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HerramientaFragment()).commit();
                }else{
                    if(id == R.id.nav_modelo){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ModeloFragment()).commit();
                    }else{
                        if(id == R.id.nav_home){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Blog()).commit();
                        }else{
                            if(id == R.id.nav_compartir){
                                Toast.makeText(HomeActivity.this,"Compartir con Redes Sociales",Toast.LENGTH_SHORT).show();
                            }else{
                                if(id == R.id.nav_enviar){
                                    Toast.makeText(HomeActivity.this,"Enviar Mensaje",Toast.LENGTH_SHORT).show();
                                }else{
                                        auth.signOut();
                                        startActivity(new Intent(HomeActivity.this,MainActivity.class));
                                        finish();
                                }
                            }
                        }
                    }
                }
            }
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getDataUser(){

        String id = auth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("nombre").getValue().toString();
                    String mast2 = dataSnapshot.child("cuenta").getValue().toString();
                    TextView x = findViewById(R.id.nombreUsuarioText);
                    x.setText(mast);
                    TextView x2 = findViewById(R.id.emailUsuarioText);
                    x2.setText(mast2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}