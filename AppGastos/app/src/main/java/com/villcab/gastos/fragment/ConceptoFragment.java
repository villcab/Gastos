package com.villcab.gastos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.villcab.gastos.R;
import com.villcab.gastos.adapters.ConceptoAdapter;
import com.villcab.gastos.data.DConcepto;
import com.villcab.gastos.entitys.Categoria;
import com.villcab.gastos.entitys.Concepto;
import com.villcab.gastos.utils.App;

import java.util.ArrayList;
import java.util.List;

public class ConceptoFragment extends Fragment {

    public static final String ARG_SECTION_TITLE = "section_number";

    private View viewFragment;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    List<Concepto> entitys;

    public static ConceptoFragment newInstance(String sectionTitle) {
        ConceptoFragment fragment = new ConceptoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public ConceptoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewFragment = inflater.inflate(R.layout.fragment_concepto, container, false);

        recycler = (RecyclerView) viewFragment.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(viewFragment.getContext());
        recycler.setLayoutManager(layoutManager);

        // Crear un nuevo adaptador
        /*adapter = new ConceptoAdapter(entitys);
        recycler.setAdapter(adapter);*/
        Log.e(App.TAG, "Primero el createview");
        return viewFragment;
    }

    @Override
    public void onResume() {
        Log.e(App.TAG, "Segundo onresume");
        loadEntitys();
        super.onResume();
    }

    public void loadEntitys() {
        try {
            DConcepto data = new DConcepto(viewFragment.getContext(), Concepto.class);
            entitys = data.listAll();
        } catch (Exception e) {
            Log.e(App.TAG, "Error al cargar la entidades: " + e.toString());
        }

        Categoria c = new Categoria(1L, "Frutas", "Frutas del dia para desayunos");
        for (Concepto item : entitys) {
            item.setCategoria(c);
        }
        adapter = new ConceptoAdapter(entitys);
        recycler.setAdapter(adapter);
    }

}
