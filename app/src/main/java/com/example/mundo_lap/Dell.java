package com.example.mundo_lap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Dell extends Fragment {

    DatabaseReference mDatabase;
    FirebaseAuth mAuth;

    Button back;

    Button descripcion1;
    Button descripcion2;
    Button descripcion3;
    Button descripcion4;
    Button descripcion5;
    Button descripcion6;
    Button descripcion7;
    Button descripcion8;
    Button descripcion9;
    Button descripcion10;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_asus,container,false);

        back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment nuevoFragmento = new ModeloFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, nuevoFragmento);
                transaction.addToBackStack(null);
                //Commit a la transacción
                transaction.commit();
            }
        });

        mDatabase.child("Marcas").child("Dell").child("001").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title1);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio1);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image1);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion1 = view.findViewById(R.id.fav1);
        descripcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("001").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("002").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title2);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio2);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image2);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion2 = view.findViewById(R.id.fav2);
        descripcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("002").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("003").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title3);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio3);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image3);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion3 = view.findViewById(R.id.fav3);
        descripcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("003").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("004").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title4);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio4);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image4);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion4 = view.findViewById(R.id.fav4);
        descripcion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("004").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("005").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title5);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio5);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image5);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion5 = view.findViewById(R.id.fav5);
        descripcion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("005").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("006").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title6);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio6);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image6);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion6 = view.findViewById(R.id.fav6);
        descripcion6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("006").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("007").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title7);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio7);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image7);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion7 = view.findViewById(R.id.fav7);
        descripcion7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("007").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("008").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title8);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio8);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image8);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion8 = view.findViewById(R.id.fav8);
        descripcion8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("008").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("009").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title9);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio9);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image9);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion9 = view.findViewById(R.id.fav9);
        descripcion9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("009").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        mDatabase.child("Marcas").child("Dell").child("010").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String mast = dataSnapshot.child("modelo").getValue().toString();
                    String mast2 = dataSnapshot.child("precio").getValue().toString();
                    String mast3 = dataSnapshot.child("imagen").getValue().toString();
                    TextView x = view.findViewById(R.id.post_title10);
                    x.setText(mast);
                    TextView x2 = view.findViewById(R.id.post_precio10);
                    x2.setText(mast2);
                    ImageView x3 = view.findViewById(R.id.post_image10);
                    Picasso.get().load(mast3).into(x3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        descripcion10 = view.findViewById(R.id.fav10);
        descripcion10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("Marcas").child("Dell").child("010").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String mast = dataSnapshot.child("caracteristicas").getValue().toString();

                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Caracteristicas");
                            builder.setMessage(mast);
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Hacer cosas aqui al hacer clic en el boton de aceptar
                                }
                            });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        return  view;
    }
}
