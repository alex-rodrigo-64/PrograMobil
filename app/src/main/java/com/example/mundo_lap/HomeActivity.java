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
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.my_menu);

        NavigationView navigationView = findViewById(R.id.nav_home);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this, drawer,toolbar,R.string.abrir_navigation_drawner,R.string.cerrar_navigation_drawner);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CuentaFragment()).commit();
        }else{
            if(id == R.id.nav_carrera){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CarreraFragment()).commit();
            }else{
                if(id == R.id.nav_herramienta){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HerramientaFragment()).commit();
                }else{
                    if(id == R.id.nav_modelo){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ModeloFragment()).commit();
                    }else{
                        if(id == R.id.nav_caracteristicas){
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CaracteristicaFragment()).commit();
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
}
