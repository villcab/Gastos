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
import com.villcab.gastos.adapters.CategoriaAdapter;
import com.villcab.gastos.data.DCategoria;
import com.villcab.gastos.entitys.Categoria;
import com.villcab.gastos.utils.App;

import java.util.List;

public class CategoriaFragment extends Fragment {

    private View viewFragment;

    public static final String ARG_SECTION_TITLE = "section_number";

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Categoria> entitys;

    public static CategoriaFragment newInstance(String sectionTitle) {
        CategoriaFragment fragment = new CategoriaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragment.setArguments(args);
        return fragment;
    }

    public CategoriaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewFragment = inflater.inflate(R.layout.fragment_categoria, container, false);

        recycler = (RecyclerView) viewFragment.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(viewFragment.getContext());
        recycler.setLayoutManager(layoutManager);

        // Crear un nuevo adaptador
        /*adapter = new CategoriaAdapter(entitys);
        recycler.setAdapter(adapter);*/
        return viewFragment;
    }

    @Override
    public void onResume() {
        loadEntitys();
        super.onResume();
    }

    public void loadEntitys() {
        try {
            DCategoria data = new DCategoria(viewFragment.getContext(), Categoria.class);
            entitys = data.listAll();
        } catch (Exception e) {
            Log.e(App.TAG, "Error al cargar la entidades: " + e.toString());
        }
        adapter = new CategoriaAdapter(entitys);
        recycler.setAdapter(adapter);
    }

}
