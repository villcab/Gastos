package com.villcab.gastos.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.villcab.gastos.entitys.Concepto;
import com.villcab.gastos.utils.App;
import com.villcab.gastos.utils.model.Wrapper;

import java.util.List;

public class DConcepto extends Wrapper {

    public DConcepto(Context context, Class type) throws Exception {
        super(context, type);
    }

    public DConcepto(Context context, SQLiteDatabase connection) {
        super(context, connection);
    }

    public List<Concepto> listAll() {
        String query = String.format("SELECT * FROM %s ORDER BY id DESC", tableName);
        Log.d(App.TAG, query);
        List<Concepto> list = this.list(query, new Concepto());
        return list;
    }

    public boolean searchByNombre(String nombre) {
        String query = String.format("SELECT * FROM %s WHERE upper(nombre) = upper('%s')", tableName, nombre);
        Log.d(App.TAG, query);
        List<Concepto> list = this.list(query, new Concepto());
        return !list.isEmpty();
    }

}
