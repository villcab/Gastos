package com.villcab.gastos.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.villcab.gastos.R;
import com.villcab.gastos.entitys.Concepto;

import java.util.List;

public class ConceptoAdapter extends RecyclerView.Adapter<ConceptoAdapter.EntityViewHolder> {

    private List<Concepto> items;

    public ConceptoAdapter(List<Concepto> items) {
        this.items = items;
    }

    @Override
    public EntityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_concepto, viewGroup, false);
        return new EntityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EntityViewHolder entityViewHolder, int i) {
        entityViewHolder.imagen.setImageResource(R.drawable.apple);
        entityViewHolder.nombre.setText(items.get(i).getNombre());
        entityViewHolder.categoria.setText(items.get(i).getCategoria().getNombre());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class EntityViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView categoria;

        public EntityViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.cconcep_image);
            nombre = (TextView) v.findViewById(R.id.cconcep_nombre);
            categoria = (TextView) v.findViewById(R.id.cconcep_categoria);
        }
    }

}
