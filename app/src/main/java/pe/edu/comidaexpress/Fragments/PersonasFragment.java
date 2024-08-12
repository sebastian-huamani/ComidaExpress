package pe.edu.comidaexpress.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pe.edu.comidaexpress.Adaptadores.AdapterPersona;
import pe.edu.comidaexpress.Entidades.Persona;
import pe.edu.comidaexpress.R;

public class PersonasFragment extends Fragment {

    AdapterPersona adapterPersona;
    RecyclerView recyclerView;

    ArrayList<Persona> lista;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.persona_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycleView);
        lista = new ArrayList<>();

        // cargamos lista
        cargarLista();
        // mostrar
        mostrarData();

        return view;
    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPersona = new AdapterPersona(getContext(), lista);
        recyclerView.setAdapter(adapterPersona);

        adapterPersona.setOnClickLister(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = lista.get(recyclerView.getChildAdapterPosition(v)).getNombre();
                Toast.makeText(getContext(), "Selecciondo: " + nombre, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarLista() {
        lista.add(new Persona("Cangrejo", "2000-08-22", R.drawable.cangrejo ));
        lista.add(new Persona("Cerdo", "2001-09-23", R.drawable.cerdo ));
        lista.add(new Persona("Gato", "2011-02-02", R.drawable.gato ));
        lista.add(new Persona("Hamster", "2024-12-01", R.drawable.hamster ));
        lista.add(new Persona("Pinguino", "2000-08-22", R.drawable.pinguino ));
    }
}
