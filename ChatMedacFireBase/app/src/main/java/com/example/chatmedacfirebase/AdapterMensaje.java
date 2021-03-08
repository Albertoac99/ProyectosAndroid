package com.example.chatmedacfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapterMensaje extends RecyclerView.Adapter<AdapterMensaje.HolderMensaje> {

    private List<Mensaje> lMensajes = new ArrayList<>();
    private Context c;

    public AdapterMensaje(Context c){
        this.c = c;
    }

    public void addMensaje(Mensaje e){
        lMensajes.add(e);
    }
    @NonNull
    @Override
    public AdapterMensaje.HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HolderMensaje(LayoutInflater.from(c).inflate(R.layout.card_view_mensaje, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMensaje.HolderMensaje holder, int position) {
        holder.nombreMensaje.setText(lMensajes.get(position).getsNombre());
        holder.horaMensaje.setText(lMensajes.get(position).getsHora());
        holder.mensajeMensaje.setText(lMensajes.get(position).getsMensaje());
        if (lMensajes.get(position).getUrlImagen().length() > 0){
            Glide.with(c).load(lMensajes.get(position).getUrlImagen()).into(holder.fotoMensaje);
        }
    }

    @Override
    public int getItemCount() {
        return lMensajes.size();
    }

    public static class HolderMensaje extends RecyclerView.ViewHolder{
        TextView nombreMensaje;
        TextView horaMensaje;
        TextView mensajeMensaje;
        ImageView fotoMensaje;
        public HolderMensaje(@NonNull View itemView) {
            super(itemView);
            nombreMensaje = itemView.findViewById(R.id.nombreMensaje);
            horaMensaje = itemView.findViewById(R.id.horaMensaje);
            mensajeMensaje = itemView.findViewById(R.id.mensajeMensaje);
            fotoMensaje = itemView.findViewById(R.id.fotoMensaje);
        }
    }
}
