package com.example.mundo_lap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button Ingresar;
    EditText correo;
    EditText pass;

    FirebaseAuth auth;
    DatabaseReference mDatabase;
    String lord;

    String email;
    String pwd;

    Button nuevaCuenta;
    //attributes sign in google by rudy
    Button signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private String TAG = "MainActivity";
    private int RC_SIGN_IN = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //onCreate sign in google by rudy
        signInButton = findViewById(R.id.buttonLogInGoogle);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id ))
                .requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        //~~by rudy
        correo = findViewById(R.id.Email);
        pass = findViewById(R.id.password);
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
    //methods signIn google by rudy
    private void signIn(){

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();

        startActivityForResult(signInIntent,0);
    //  Toast.makeText(MainActivity.this,"Test2",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Toast.makeText(MainActivity.this,requestCode,Toast.LENGTH_SHORT).show();
        if(resultCode == 0){
          //  Toast.makeText(MainActivity.this,"Test3",Toast.LENGTH_SHORT).show();
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        try {
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            Toast.makeText(MainActivity.this,"Signed In Successfully",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
            startActivity(new Intent(MainActivity.this,HomeActivity.class ));
            finish();
        }
        catch (ApiException e){
            Toast.makeText(MainActivity.this,"Signed is Not Successfully",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }
    private void FirebaseGoogleAuth(GoogleSignInAccount acct){
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);

        auth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = auth.getCurrentUser();
                    updateUI(user);
                    startActivity(new Intent(MainActivity.this,HomeActivity.class ));
                    finish();

                } else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }
    private void updateUI(FirebaseUser user){
       // btnSignOut.setVisibility(View.VISIBLE );
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account != null){
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personEmail = account.getEmail();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(MainActivity.this, personName +personEmail, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,HomeActivity.class ));
            finish();
        }
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
    //~~Methods signIn google by rudy

    @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }
    }

}
