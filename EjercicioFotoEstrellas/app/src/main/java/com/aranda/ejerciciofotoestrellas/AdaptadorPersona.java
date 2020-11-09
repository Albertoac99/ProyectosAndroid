package com.aranda.ejerciciofotoestrellas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Persona;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.HolderPersona>{

    private final ArrayList<Persona> gente;


    public AdaptadorPersona(ArrayList<Persona> gente){
        this.gente = gente;
    }


    public void refrescar(){
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdaptadorPersona.HolderPersona onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos,parent,false);
        return new HolderPersona(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersona.HolderPersona holder, int position) {
        holder.txtTitulo.setText(gente.get(position).getTitulo());
        holder.txtSubtitulo.setText(gente.get(position).getSubtitulo());
        holder.ratingBar.setRating(gente.get(position).getEstrellas());
        holder.cardPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Informacion pulsada" +position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return gente.size();
    }

    public static class HolderPersona extends RecyclerView.ViewHolder{

        CardView cardPersona;
        TextView txtTitulo;
        TextView txtSubtitulo;
        RatingBar ratingBar;

        public HolderPersona(@NonNull View itemView) {
            super(itemView);

            cardPersona = itemView.findViewById(R.id.cardPersona);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtSubtitulo = itemView.findViewById(R.id.txtSubtitulo);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }


    }
}
