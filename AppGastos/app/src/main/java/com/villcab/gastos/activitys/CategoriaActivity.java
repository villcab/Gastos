package com.villcab.gastos.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.villcab.gastos.R;
import com.villcab.gastos.data.DCategoria;
import com.villcab.gastos.entitys.Categoria;
import com.villcab.gastos.utils.App;
import com.villcab.gastos.utils.model.Action;

public class CategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        setToolbar();
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.primaryColorDark));
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.undo_inverse);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void save() {
        TextView tvNombre = (TextView) findViewById(R.id.nombre);
        TextView tvDescripcion = (TextView) findViewById(R.id.descripcion);

        Categoria entity = new Categoria();
        entity.setNombre(tvNombre.getText().toString());
        entity.setDescripcion(tvDescripcion.getText().toString());

        if (!entity.getNombre().isEmpty()) {
            DCategoria data = null;
            try {
                data = new DCategoria(this, Categoria.class);

                if (data.searchByNombre(entity.getNombre().trim())) {
                    Toast.makeText(this, "Ya existe un concepto con el nombre indicado", Toast.LENGTH_SHORT).show();

                } else {
                    entity.setAction(Action.INSERT);
                    data.save(entity);
                    Toast.makeText(this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.e(App.TAG, "Error al guardar el registro: " + e.toString());
            }

        } else {
            Toast.makeText(this, "Nombre no puede ser vacio", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_concepto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.e(App.TAG, "Id: " + id);
        switch (id) {
            case R.id.action_save:
                save();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
