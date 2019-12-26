package com.example.mundo_lap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

//import com.example.mundo_lap.herramientas.HerrAutoActivity;
//import com.example.mundo_lap.herramientas.HerrOfficeActivity;

public class HerramientaFragment extends Fragment {

    Button irHome;
    ImageButton ib1;
    ImageButton ib2;
    ImageButton ib3;
    public String tBoton = "Autocad";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_herramientas,container,false);
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
       /* //
        ib1 = view.findViewById(R.id.imageButton_autocad);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), HerrAutoActivity.class);
                getActivity().startActivity(intent);
            }
        });

        ib2 = view.findViewById(R.id.imageButton_office);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), HerrOfficeActivity.class);
                getActivity().startActivity(intent);
            }
        });
        ib3 = view.findViewById(R.id.imageButton_ide);
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), HerrOfficeActivity.class);
                getActivity().startActivity(intent);
            }
        });*/


        return  view;
    }
}
