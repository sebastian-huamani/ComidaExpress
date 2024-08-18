package pe.edu.comidaexpress.Adaptadores;

import android.content.Context;
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

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolder> implements View.OnClickListener  {

    LayoutInflater layoutInflater;
    ArrayList<Producto> lista;

    private View.OnClickListener listener;

    public AdapterProducto(Context context, ArrayList<Producto> lista) {
        this.layoutInflater = LayoutInflater.from(context);
        this.lista = lista;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.lista_personas, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String codigo = lista.get(position).getCodigo();
        String nombre = lista.get(position).getNombre();
        Double precio = lista.get(position).getPrecio();
        int image = lista.get(position).getImageId();

        holder.nombre.setText(nombre);
//        holder.codigo.setText(codigo);
        holder.precio.setText(String.valueOf(precio));
        holder.imagenId.setImageResource(image);
    }

    @Override
    public int getItemCount() { return lista.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, codigo, precio;
        ImageView imagenId;
        Button btn_agregar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            precio = itemView.findViewById(R.id.precio);
            imagenId = itemView.findViewById(R.id.imagen);
            btn_agregar = itemView.findViewById(R.id.btn_agregar);
        }
    }
}
