package logic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aranda.feriapp.R;

import view.ListaCasetas;

import static logic.Datos.casetas;

public class AdaptadorCaseta extends RecyclerView.Adapter<AdaptadorCaseta.HolderProducto>{

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
    public AdaptadorCaseta.HolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.casetas,parent,false);
        return new HolderProducto(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCaseta.HolderProducto holder, int position) {
        holder.txtNombreCaseta.setText(Datos.casetas.get(position).getNombreCaseta());
        holder.txtAforoCaseta.setText(Datos.casetas.get(position).getAforoActual()+"/"+casetas.get(position).getAforoMaximo());
        holder.txtHorarioCaseta.setText(Datos.casetas.get(position).getHorario());

        holder.imgCaseta.setImageResource(R.drawable.gitana);

        holder.cardCaseta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Informacion pulsada" +position);
                Intent intent = new Intent(c, ListaCasetas.class);
                posicion = position;
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Datos.casetas.size();
    }


    public static class HolderProducto extends RecyclerView.ViewHolder{

        CardView cardCaseta;
        TextView txtNombreCaseta;
        TextView txtAforoCaseta;
        TextView txtHorarioCaseta;
        ImageView imgCaseta;

        public HolderProducto(@NonNull View itemView) {
            super(itemView);

            cardCaseta = itemView.findViewById(R.id.cardCaseta);
            txtNombreCaseta = itemView.findViewById(R.id.txtNombreCaseta);
            txtAforoCaseta = itemView.findViewById(R.id.txtAforoCaseta);
            txtHorarioCaseta = itemView.findViewById(R.id.txtHorarioCaseta);
            imgCaseta = itemView.findViewById(R.id.imgCaseta);
        }


    }
}

