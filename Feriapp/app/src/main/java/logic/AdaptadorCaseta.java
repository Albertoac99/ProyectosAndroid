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
        holder.txtNombre.setText(casetas.get(position).);
        holder.txtPrecio.setText(casetas.get(position).);
        holder.ratingBar.setRating(casetas.get(position).);

        holder.cardProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Informacion pulsada" +position);
                Intent intent = new Intent(c, Editar.class);
                posicion = position;
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return casetas.size();
    }


    public static class HolderProducto extends RecyclerView.ViewHolder{

        CardView cardProducto;
        TextView txtNombre;
        TextView txtPrecio;
        RatingBar ratingBar;
        ImageView imgView;

        public HolderProducto(@NonNull View itemView) {
            super(itemView);

            cardProducto = itemView.findViewById(R.id.cardProducto);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imgView = itemView.findViewById(R.id.imgView);
        }


    }
}

