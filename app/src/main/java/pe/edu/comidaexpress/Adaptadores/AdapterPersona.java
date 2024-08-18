package pe.edu.comidaexpress.Adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pe.edu.comidaexpress.Entidades.Persona;
import pe.edu.comidaexpress.R;

public class AdapterPersona extends RecyclerView.Adapter<AdapterPersona.ViewHolder> implements View.OnClickListener  {

    LayoutInflater layoutInflater;
    ArrayList<Persona> model;

    private View.OnClickListener listener;

    public AdapterPersona(Context context, ArrayList<Persona> model){
        this.layoutInflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.lista_personas, parent, false);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    public void setOnClickLister(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getNombre();
//        String fechanacimiento = model.get(position).getFechanacimiento();
        int imagen = model.get(position).getImagenId();
        holder.nombre.setText(nombre);
//        holder.fechanacimiento.setText(fechanacimiento);
        holder.imagenID.setImageResource(imagen);
        holder.btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("btn", nombre);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, fechanacimiento;
        ImageView imagenID;

        Button btn_agregar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            nombre = itemView.findViewById(R.id.titlo_persona);
//            fechanacimiento = itemView.findViewById(R.id.fecha_nacimiento);
//            imagenID = itemView.findViewById(R.id.imagen_persona);
            btn_agregar = itemView.findViewById(R.id.btn_agregar);
        }
    }
}
