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

public class CarreraFragment extends Fragment {

    Button irHome;
    Button asus;
    Button hp;
    Button lenovo;
    Button acer;
    Button mac;
    Button dell;
    Button toshiba;
    Button huawei;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facultades,container,false);

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

        asus = view.findViewById(R.id.agronomia);
        asus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new HerrOfficeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
        hp = view.findViewById(R.id.arquitectura);
        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new HerrOfficeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
        lenovo = view.findViewById(R.id.derecho);
        lenovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new HerrOfficeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
        acer = view.findViewById(R.id.economia);
        acer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new HerrOfficeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });

        mac = view.findViewById(R.id.humanidades);
        mac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new HerrOfficeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
/*
        dell = view.findViewById(R.id.dell);
        dell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new Dell();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });

        toshiba = view.findViewById(R.id.toshiba);
        toshiba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new Toshiba();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });
        huawei = view.findViewById(R.id.huawei);
        huawei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new Huawei();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });*/
        return view;
    }
}
