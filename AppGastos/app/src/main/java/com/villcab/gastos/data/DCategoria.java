package com.villcab.gastos.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.villcab.gastos.entitys.Categoria;
import com.villcab.gastos.utils.App;
import com.villcab.gastos.utils.model.Wrapper;

import java.util.List;

public class DCategoria extends Wrapper {

    public DCategoria(Context context, Class type) throws Exception {
        super(context, type);
    }

    public DCategoria(Context context, SQLiteDatabase connection) {
        super(context, connection);
    }

    public List<Categoria> listAll() {
        String query = String.format("SELECT * FROM %s ORDER BY id DESC", tableName);
        Log.d(App.TAG, query);
        List<Categoria> list = this.list(query, new Categoria());
        return list;
    }

    public boolean searchByNombre(String nombre) {
        String query = String.format("SELECT * FROM %s WHERE upper(nombre) = upper('%s')", tableName, nombre);
        Log.d(App.TAG, query);
        List<Categoria> list = this.list(query, new Categoria());
        return !list.isEmpty();
    }

}
