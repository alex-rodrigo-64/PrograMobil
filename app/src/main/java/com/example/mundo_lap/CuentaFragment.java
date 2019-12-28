package com.example.mundo_lap;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;


public class CuentaFragment extends Fragment {

    Button irHome;
    Button favoritos;
    FirebaseAuth mAuth;
    String id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuenta,container,false);

        mAuth = FirebaseAuth.getInstance();
        id = mAuth.getUid();

        irHome = view.findViewById(R.id.ir_home);
        irHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new Blog();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                 //Commit a la transacción
                transaction.commit();
            }
        });

        favoritos = view.findViewById(R.id.favoritos_id);
        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Favoritos.class);
                intent.putExtra("nombre", id);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }


}
