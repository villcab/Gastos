package com.villcab.gastos.entitys;

import com.villcab.gastos.utils.model.Entity;
import com.villcab.gastos.utils.model.annotations.Key;
import com.villcab.gastos.utils.model.annotations.TableName;

@TableName(name = "tipo_clasificador")
public class TipoClasificador extends Entity {

    @Key
    private Long id;
    private String nombre;
    private String descripcion;

    public TipoClasificador() {
    }

    public TipoClasificador(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoClasificador that = (TipoClasificador) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "TipoClasificador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
