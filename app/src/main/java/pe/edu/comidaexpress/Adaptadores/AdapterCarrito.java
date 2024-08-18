package pe.edu.comidaexpress.Adaptadores;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pe.edu.comidaexpress.Entidades.Producto;
import pe.edu.comidaexpress.R;

public class AdapterCarrito extends RecyclerView.Adapter<AdapterCarrito.ViewHolder> implements View.OnClickListener {

    LayoutInflater layoutInflater;
    ArrayList<Producto> lista;

    private View.OnClickListener listener;

    public  AdapterCarrito(Context context, ArrayList<Producto> lista) {
        this.layoutInflater = LayoutInflater.from(context);
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.carrito_item, parent, false);
        view.setOnClickListener(this);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = lista.get(position).getNombre();
        Double precio = lista.get(position).getPrecio();
        int image = lista.get(position).getImageId();

        holder.nombre.setText(nombre);
        holder.precio.setText(String.valueOf(precio));
        holder.image.setImageResource(image);
    }

    @Override
    public int getItemCount() {return lista.size();}

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, codigo, precio;
        ImageView image;
        Button btn_eliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_carrito);
            precio = itemView.findViewById(R.id.precio_carrito);
            image = itemView.findViewById(R.id.imagen_carrito);
            btn_eliminar = itemView.findViewById(R.id.btn_elimnar);
        }
    }
}
