package com.villcab.gastos.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.villcab.gastos.R;
import com.villcab.gastos.entitys.Categoria;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.EntityViewHolder> {

    private List<Categoria> items;

    public CategoriaAdapter(List<Categoria> items) {
        this.items = items;
    }

    @Override
    public EntityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_categoria, viewGroup, false);
        return new EntityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EntityViewHolder entityViewHolder, int i) {
        entityViewHolder.nombre.setText(items.get(i).getNombre());
        entityViewHolder.descripcion.setText(items.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class EntityViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView descripcion;

        public EntityViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.nombre);
            descripcion = (TextView) v.findViewById(R.id.descripcion);
        }
    }

}
