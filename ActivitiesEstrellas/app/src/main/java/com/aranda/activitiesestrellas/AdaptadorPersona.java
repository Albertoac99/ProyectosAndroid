package com.aranda.activitiesestrellas;

import android.content.Context;
import android.content.Intent;
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

    Context c;

    public AdaptadorPersona(Context c){
        this.c = c;
    }


    public void refrescar(){
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdaptadorPersona.HolderPersona onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elements,parent,false);
        return new HolderPersona(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersona.HolderPersona holder, int position) {
        holder.txtNombre.setText(Datos.gente.get(position).getNombre());
        holder.txtApellidos.setText(Datos.gente.get(position).getApellidos());
        holder.ratingBar.setRating(Datos.gente.get(position).getEstrellas());
        holder.cardPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Informacion pulsada" +position);
                Intent intent = new Intent(c, SegundaPantalla.class);

                c.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Datos.gente.size();
    }

    public static class HolderPersona extends RecyclerView.ViewHolder{

        CardView cardPersona;
        TextView txtNombre;
        TextView txtApellidos;
        RatingBar ratingBar;

        public HolderPersona(@NonNull View itemView) {
            super(itemView);

            cardPersona = itemView.findViewById(R.id.cardPersona);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtApellidos = itemView.findViewById(R.id.txtApellidos);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }


    }
}
