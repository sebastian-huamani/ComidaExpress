package pe.edu.comidaexpress.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pe.edu.comidaexpress.Adaptadores.AdapterCarrito;
import pe.edu.comidaexpress.Entidades.Producto;
import pe.edu.comidaexpress.FormularioActivity;
import pe.edu.comidaexpress.HomeActivity;
import pe.edu.comidaexpress.R;


public class CarritoFragment extends Fragment {

    private static final String urlservidor = "http://192.168.1.44/comidaExpress/listarCarrito.php";
    AdapterCarrito adapterCarrito;
    RecyclerView recyclerView;
    public ArrayList<Producto> lista;

    Button carrito;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carrito_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycleViewCarrito);
        lista = new ArrayList<>();
        carrito = view.findViewById(R.id.btn_comprar);

        carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent =  new Intent( v.getContext(), FormularioActivity.class );
                    startActivity(intent);

            }
        });

        cargarLista();
        return view;
    }

    public void cargarLista() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        JsonArrayRequest jsonArrayRequest  = new JsonArrayRequest(
                Request.Method.GET,
                urlservidor,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Producto> productos = new ArrayList<>();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);

                                String codigo = jsonObject.getString("codigo");
                                String nombre = jsonObject.getString("nombre");
                                Double precio = Double.valueOf(jsonObject.getString("precio"));
                                Integer imageId = Integer.valueOf(jsonObject.getString("imageId"));

                                Producto producto = new Producto(codigo, nombre, precio, imageId);
                                productos.add(producto);

                            }
                            adapterCarrito = new AdapterCarrito(getContext(), productos);
                            recyclerView.setAdapter(adapterCarrito);
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", "Error en la solicitud: " + error.getMessage());
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }


}
