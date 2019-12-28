package com.example.mundo_lap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class Favoritos extends AppCompatActivity {

    FirebaseRecyclerAdapter<ListaDatos, BlogPostHolder> firebaseRecyclerAdapter;
    RecyclerView recyclerView;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos);

        id = getIntent().getStringExtra("nombre");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        Query query = rootRef.child("Users").child(id).child("Favoritos");

        FirebaseRecyclerOptions<ListaDatos> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<ListaDatos>()
                .setQuery(query, ListaDatos.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<ListaDatos, BlogPostHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull BlogPostHolder blogPostHolder, int position, @NonNull ListaDatos blogPost) {
                blogPostHolder.setBlogPost(blogPost);
            }

            @Override
            public BlogPostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

                return new BlogPostHolder(view);
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);


    }


    @Override
    protected void onStart() {
        super.onStart();
        firebaseRecyclerAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (firebaseRecyclerAdapter!= null) {
            firebaseRecyclerAdapter.stopListening();
        }
    }


    private class BlogPostHolder extends RecyclerView.ViewHolder {
        private TextView marca, precio;
                ImageView image;

        BlogPostHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.post_imagenes);
            marca = itemView.findViewById(R.id.post_titles);
            precio = itemView.findViewById(R.id.post_precios);
        }

        void setBlogPost(ListaDatos blogPost) {
            String imageThumb = blogPost.getImagen();
            Picasso.get().load(imageThumb).into(image);
            String marcas = blogPost.getMarca();
            marca.setText(marcas);
            String precios = blogPost.getPrecio();
            precio.setText(precios);
        }
    }
}
