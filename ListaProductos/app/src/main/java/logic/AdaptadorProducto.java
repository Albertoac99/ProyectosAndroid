package logic;

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

import com.aranda.listaproductos.R;

import view.Editar;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.HolderProducto>{

    Context c;
    public static int posicion;

    public AdaptadorProducto(Context c){
        this.c = c;
    }


    public void refrescar(){
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public AdaptadorProducto.HolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos,parent,false);
        return new HolderProducto(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProducto.HolderProducto holder, int position) {
    holder.txtNombre.setText(Datos.elementos.get(position).getNombre());
    holder.txtPrecio.setText(Datos.elementos.get(position).getPrecio() + " €");
    holder.ratingBar.setRating(Datos.elementos.get(position).getEstrellas());
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
        return Datos.elementos.size();
    }


    public static class HolderProducto extends RecyclerView.ViewHolder{

        CardView cardProducto;
        TextView txtNombre;
        TextView txtPrecio;
        RatingBar ratingBar;


        public HolderProducto(@NonNull View itemView) {
            super(itemView);

            cardProducto = itemView.findViewById(R.id.cardProducto);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            ratingBar = itemView.findViewById(R.id.ratingBar);

        }


    }
}
