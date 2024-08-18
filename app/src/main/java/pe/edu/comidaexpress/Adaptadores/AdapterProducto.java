package pe.edu.comidaexpress.Adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pe.edu.comidaexpress.Entidades.Producto;
import pe.edu.comidaexpress.R;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolder> implements View.OnClickListener  {
    private static final String urlservidor = "http://192.168.1.44//comidaExpress/agregarCarrito.php";
    RequestQueue requestQueue;
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
        int image = lista.get(position).getImageId();http://192.168.1.44/

        holder.nombre.setText(nombre);
        holder.codigo.setText(codigo);
        holder.precio.setText(String.valueOf(precio));
        holder.btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.i("data", codigo);
                RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
                StringRequest stringRequest = new StringRequest(
                        Request.Method.POST,
                        urlservidor,
                        response -> {
                            Log.i("data", "aaaaa");
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.i("error", String.valueOf(volleyError));
                            }
                        }
                ){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("codigo", codigo);
                        return params;
                    }
                };

                requestQueue.add(stringRequest);

            }
        });
//        holder.imagenId.setImageResource(image);
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
            codigo = itemView.findViewById(R.id.codigo);
            imagenId = itemView.findViewById(R.id.imagen);
            btn_agregar = itemView.findViewById(R.id.btn_agregar);
        }
    }
}
