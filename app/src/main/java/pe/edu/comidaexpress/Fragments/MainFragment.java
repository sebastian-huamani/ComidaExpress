package pe.edu.comidaexpress.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pe.edu.comidaexpress.Adaptadores.AdapterProducto;
import pe.edu.comidaexpress.Entidades.Producto;
import pe.edu.comidaexpress.R;

public class MainFragment extends Fragment {

    AdapterProducto adapterProducto;
    RecyclerView recyclerView;
    ArrayList<Producto> lista;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycleViewProductos);
        lista = new ArrayList<>();

        cargarLista();
        mostrarData();

        return view;
    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterProducto = new AdapterProducto(getContext(), lista);
        recyclerView.setAdapter(adapterProducto);
    }

    private void cargarLista() {
        lista.add(new Producto("36254", "Arroz verde", 39.90, R.drawable.gato));
        lista.add(new Producto("36255", "Pato asado", 59.90, R.drawable.cerdo));
    }
}
