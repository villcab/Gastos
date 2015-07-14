package com.villcab.gastos.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.villcab.gastos.entitys.Producto;
import com.villcab.gastos.utils.App;
import com.villcab.gastos.utils.model.Wrapper;

import java.util.List;

public class DProducto extends Wrapper {

    public DProducto(Context context, Class type) throws Exception {
        super(context, type);
    }

    public DProducto(Context context, SQLiteDatabase connection) {
        super(context, connection);
    }

    public List<Producto> listAll() {
        String query = String.format("SELECT * FROM %s", tableName);
        Log.d(App.TAG, query);
        List<Producto> list = this.list(query, new Producto());
        return list;
    }

}
