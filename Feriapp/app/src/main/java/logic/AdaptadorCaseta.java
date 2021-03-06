package logic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aranda.feriapp.R;

import view.ListaCasetas;

import static logic.Datos.casetas;

public class AdaptadorCaseta extends RecyclerView.Adapter<AdaptadorCaseta.HolderCaseta>{

    Context c;
    public static int posicion;

    public AdaptadorCaseta(Context c){
        this.c = c;
    }


    public void refrescar(){
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public AdaptadorCaseta.HolderCaseta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.casetas,parent,false);
        return new HolderCaseta(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCaseta.HolderCaseta holder, int position) {
        holder.txtNombreCaseta.setText(Datos.casetas.get(position).getNombreCaseta());
        holder.txtAforoCaseta.setText("Aforo: "+Datos.casetas.get(position).getAforoActual()+"/"+casetas.get(position).getAforoMaximo());
        holder.txtHorarioCaseta.setText("Horario: "+Datos.casetas.get(position).getHorario());
        holder.txtCalle.setText("Calle: "+ casetas.get(position).getNombreCalle());
        holder.txtNumeroCaseta.setText("Numero: "+casetas.get(position).getNumeroCaseta());

        if(casetas.get(position).getTipoCaseta()==1){
            holder.imgCaseta.setImageResource(R.drawable.gitana);
        }
        else{
            holder.imgCaseta.setImageResource(R.drawable.gitanaverde);
        }

    }

    @Override
    public int getItemCount() {
        return Datos.casetas.size();
    }


    public static class HolderCaseta extends RecyclerView.ViewHolder{

        CardView cardCaseta;
        TextView txtNombreCaseta;
        TextView txtAforoCaseta;
        TextView txtHorarioCaseta;
        TextView txtCalle;
        TextView txtNumeroCaseta;
        ImageView imgCaseta;

        public HolderCaseta(@NonNull View itemView) {
            super(itemView);

            cardCaseta = itemView.findViewById(R.id.cardCaseta);
            txtNombreCaseta = itemView.findViewById(R.id.txtNombreCaseta);
            txtAforoCaseta = itemView.findViewById(R.id.txtAforoCaseta);
            txtHorarioCaseta = itemView.findViewById(R.id.txtHorarioCaseta);
            imgCaseta = itemView.findViewById(R.id.imgCaseta);
            txtCalle = itemView.findViewById(R.id.txtCalle);
            txtNumeroCaseta = itemView.findViewById(R.id.txtNumeroCaseta);
        }


    }
}

