package com.example.mundo_lap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    EditText nombre;
    EditText correo;
    EditText password;
    Button nuevaCuenta;

    private String name="";
    private String email="";
    private String contra="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cuenta);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        nombre = findViewById(R.id.nuevoNombre);
        correo = findViewById(R.id.nuevoEmail);
        password = findViewById(R.id.nuevoContraseña);
        nuevaCuenta = findViewById(R.id.nuevoUsuario);

        nuevaCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nombre.getText().toString();
                email = correo.getText().toString();
                contra = password.getText().toString();

                if(!name.isEmpty() && !email.isEmpty() && !contra.isEmpty()){

                    if(contra.length()>= 6){
                        registerUser();
                    }else{
                        Toast.makeText(RegistroActivity.this,"La Contraseña debe tener al menos 6 Caracteres",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegistroActivity.this,"Debe Completar Los Campos Vacios",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void registerUser(){

        mAuth.createUserWithEmailAndPassword(email,contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String , Object> map = new HashMap<>();
                    map.put("Nombre",name);
                    map.put("Cuenta",email);
                    map.put("Contraseña",contra);
                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task4) {
                            if(task4.isSuccessful()){
                                Toast.makeText(RegistroActivity.this, "registro exitoso", Toast.LENGTH_LONG).show();
                                Intent main = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(main);
                            }else{
                                Toast.makeText(RegistroActivity.this,"No se pudo crear los datos correctamente",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(RegistroActivity.this,"No se pudo registrar este usuario",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(RegistroActivity.this,HomeActivity.class));
            finish();
        }
    }
}
