package com.example.mundo_lap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button Ingresar;
    EditText correo;
    EditText pass;

    FirebaseAuth auth;

    String email;
    String pwd;

    Button nuevaCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        correo =  findViewById(R.id.Email);
        pass =  findViewById(R.id.password);
        Ingresar = findViewById(R.id.buttonLogIn);

        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = correo.getText().toString();
                pwd = pass.getText().toString();

                if(!email.isEmpty() && !pwd.isEmpty()){
                    loginUser();
                }else{
                    Toast.makeText(MainActivity.this,"Campos Vacios",Toast.LENGTH_SHORT).show();
                }
            }
        });

        nuevaCuenta = findViewById(R.id.crearCuenta);
        nuevaCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), RegistroActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }


    private void  loginUser(){
        auth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     startActivity(new Intent(MainActivity.this,HomeActivity.class ));
                     finish();
                 }else{
                     Toast.makeText(MainActivity.this,"No Se Pudo Iniciar Sesion, Verifique Los Datos Nuevamente",Toast.LENGTH_SHORT).show();
                 }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }
    }
}
