package com.villcab.gastos.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.villcab.gastos.R;
import com.villcab.gastos.activitys.ConceptoActivity;
import com.villcab.gastos.adapters.ConceptoAdapter;
import com.villcab.gastos.entitys.Categoria;
import com.villcab.gastos.entitys.Clasificador;
import com.villcab.gastos.entitys.Concepto;
import com.villcab.gastos.entitys.TipoClasificador;

import java.util.ArrayList;
import java.util.List;

public class ProductoFragment extends Fragment {

    private Context context;
    /**
     * Este argumento del fragmento representa el título de cada
     * sección
     */
    public static final String ARG_SECTION_TITLE = "section_number";

    /*
    Declarar instancias globales
     */
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * Crea una instancia prefabricada de {@link ProductoFragment}
     *
     * @param sectionTitle Título usado en el contenido
     * @return Instancia dle fragmento
     */
    public static ProductoFragment newInstance(String sectionTitle) {
        ProductoFragment fragment = new ProductoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public ProductoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto, container, false);
        context = view.getContext();

        // Ubicar argumento en el text view de section_fragment.xml
        /*String title = getArguments().getString(ARG_SECTION_TITLE);
        TextView titulo = (TextView) view.findViewById(R.id.title2);
        titulo.setText(title);*/

        List<Concepto> conceptos = new ArrayList<>();

        /*TipoClasificador tc = new TipoClasificador();
        tc.setId(1L);
        tc.setNombre("categoria productos");
        tc.setDescripcion("para categorizar los productos");

        Clasificador c = new Clasificador();
        c.setId(1L);
        c.setIdTipoClasificador(tc.getId());
        c.setDescripcion("Frutas");*/

        Categoria c = new Categoria(1L, "Frutas", "Frutas del dia para desayunos");

        Concepto c1 = new Concepto();
        c1.setId(1L);
        c1.setNombre("Manzana");
        c1.setGuid("xxxx-wrffd-ssff");
        c1.setCategoria(c);
        conceptos.add(c1);

        Concepto c2 = new Concepto();
        c2.setId(2L);
        c2.setNombre("Pera");
        c2.setGuid("xxxx-wrffd-ssfa");
        c2.setCategoria(c);
        conceptos.add(c2);

        Concepto c3 = new Concepto();
        c3.setId(3L);
        c3.setNombre("Sandia");
        c3.setGuid("xxxx-wrffd-ssfb");
        c3.setCategoria(c);
        conceptos.add(c3);

        Concepto c4 = new Concepto();
        c4.setId(4L);
        c4.setNombre("Uva");
        c4.setGuid("xxxx-wrffd-ssfc");
        c4.setCategoria(c);
        conceptos.add(c4);

        // Obtener el Recycler
        recycler = (RecyclerView) view.findViewById(R.id.recycler_concept);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        layoutManager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(layoutManager);

        // Crear un nuevo adaptador
        adapter = new ConceptoAdapter(conceptos);
        recycler.setAdapter(adapter);

        return view;
    }

}
