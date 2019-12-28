package com.example.mundo_lap;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mundo_lap.facultad.AgronomiaFragment;
import com.example.mundo_lap.facultad.ArquitecturaFragment;
import com.example.mundo_lap.facultad.DerechoFragment;
import com.example.mundo_lap.facultad.EconomiaFragment;
import com.example.mundo_lap.facultad.TecnologiaFragment;

public class FacultadFragment extends Fragment {

    Button irHome;
    Button btAgro;
    Button btArq;
    Button btDer;
    Button acer;
    Button btEco;
    Button btTec;
    Button toshiba;
    Button huawei;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facultad,container,false);


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
        btAgro = view.findViewById(R.id.id_agro);
        btAgro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new AgronomiaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
        btArq = view.findViewById(R.id.id_arq);
        btArq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new ArquitecturaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
        btDer = view.findViewById(R.id.id_der);
        btDer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new DerechoFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
        btEco = view.findViewById(R.id.id_eco);
        btEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new EconomiaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });

        btTec = view.findViewById(R.id.id_tec);
        btTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new TecnologiaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
        return view;
    }
}
