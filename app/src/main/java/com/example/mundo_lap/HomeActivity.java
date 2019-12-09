package com.example.mundo_lap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mundo_lap.rows_cards.rowClass;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    FirebaseAuth auth;
    private RecyclerView mBloglist;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        mDatabase= FirebaseDatabase.getInstance().getReference().child("item");
        mDatabase.keepSynced(true);

        mBloglist=(RecyclerView)findViewById(R.id.my_recycleview);
        mBloglist.setHasFixedSize(true);
        mBloglist.setLayoutManager(new LinearLayoutManager(this));
        //
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
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<rowClass,items> adapter =new FirebaseRecyclerAdapter<rowClass, items>
                (rowClass.class, R.layout.blog_row, items.class, mDatabase){
            @Override
            protected void onBindViewHolder(@NonNull items holder, int position, @NonNull rowClass model) {

            }


            @Override
            public items onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };

    }
    public static class items extends RecyclerView.ViewHolder
    {
        View mView;
        public items(View itemView){
            super(itemView);
            mView=itemView;
        }
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
