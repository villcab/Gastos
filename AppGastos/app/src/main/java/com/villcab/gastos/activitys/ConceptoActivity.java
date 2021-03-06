package com.villcab.gastos.activitys;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.villcab.gastos.R;
import com.villcab.gastos.data.DConcepto;
import com.villcab.gastos.entitys.Concepto;
import com.villcab.gastos.utils.App;
import com.villcab.gastos.utils.model.Action;

import java.util.UUID;

public class ConceptoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concepto);

        setToolbar(); // Setear Toolbar como action bar
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_concepto, menu);
        return true;
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

    public void save() {
        TextView tvNombre = (TextView) findViewById(R.id.concepto_nombre);
        TextView tvDescripcion = (TextView) findViewById(R.id.concepto_descripcion);

        Concepto entity = new Concepto();
        entity.setNombre(tvNombre.getText().toString());

        if (!entity.getNombre().isEmpty()) {
            /*UUID idOne = UUID.randomUUID();
            Log.e(App.TAG, idOne.toString());
            entity.setGuid(idOne.toString());*/
            DConcepto data = null;
            try {
                data = new DConcepto(this, Concepto.class);

                /*if (data.searchByNombre(entity.getNombre().trim())) {
                    Toast.makeText(this, "Ya existe un concepto con el nombre indicado", Toast.LENGTH_SHORT).show();
                } else {*/
                    entity.setAction(Action.INSERT);

                    data.save(entity);
                    Toast.makeText(this, "Registro guardado correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                /*}*/

            } catch (Exception e) {
                e.printStackTrace();
                Log.e(App.TAG, "Error al guardar el registro: " + e.toString());
            }

        } else {
            Toast.makeText(this, "Nombre no puede ser vacio", Toast.LENGTH_SHORT).show();
        }
    }

}
