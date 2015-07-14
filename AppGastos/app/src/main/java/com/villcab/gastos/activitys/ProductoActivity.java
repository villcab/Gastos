package com.villcab.gastos.activitys;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.villcab.gastos.R;
import com.villcab.gastos.data.DProducto;
import com.villcab.gastos.entitys.Producto;
import com.villcab.gastos.utils.App;
import com.villcab.gastos.utils.model.Action;

public class ProductoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_producto, menu);
        return true;
    }

    public void addProducto(View view) {
        try {
            Producto model = new Producto();
            EditText nombre = (EditText) findViewById(R.id.edittext_nombre);
            model.setNombre(nombre.getText().toString());

            if (validar(model)) {
                DProducto data =new DProducto(this, Producto.class);
                model.setAction(Action.INSERT);
                data.save(model);
                Toast.makeText(this, "Registro guardado exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            }

        } catch (Exception e) {
            Log.e(App.TAG, "Error al guardar el registro", e);
        }
    }

    public boolean validar(Producto entity) {

        if (entity.getNombre().isEmpty()) {
            return false;
        }

        return true;

    }

    public void cancelar(View view) {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
