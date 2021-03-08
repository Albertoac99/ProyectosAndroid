package com.aranda.chatmedac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class AdapterMensaje extends RecyclerView.Adapter<AdapterMensaje.HolderMensaje> {

    private List<Mensaje> listMensaje = new ArrayList<>();
    private Context c;

    public AdapterMensaje(Context c){
        this.c = c;
    }

    public void addMensaje(Mensaje m){
        listMensaje.add(m);
        notifyItemInserted(listMensaje.size());
    }

    @NonNull
    @Override
    public AdapterMensaje.HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderMensaje(LayoutInflater.from(c).inflate(R.layout.card_view_mensaje, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMensaje.HolderMensaje holder, int position) {
        holder.nombreMensaje.setText(listMensaje.get(position).getNombre());
        holder.horaMensaje.setText(listMensaje.get(position).getHora());
        holder.mensajeMensaje.setText(listMensaje.get(position).getMensaje());
        if(listMensaje.get(position).getUrlImagen().length() > 0){
            Glide.with(c).load(listMensaje.get(position).getUrlImagen()).into(holder.imagenMensaje);
        }
    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }

    public static class HolderMensaje extends RecyclerView.ViewHolder{

        TextView nombreMensaje;
        TextView horaMensaje;
        TextView mensajeMensaje;
        ImageView imagenMensaje;

        public HolderMensaje(@NonNull View itemView) {
            super(itemView);

            nombreMensaje = itemView.findViewById(R.id.nombreMensaje);
            horaMensaje = itemView.findViewById(R.id.horaMensaje);
            mensajeMensaje = itemView.findViewById(R.id.mensajeMensaje);
            imagenMensaje = itemView.findViewById(R.id.imagenMensaje);

        }
    }
}
