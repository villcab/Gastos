package com.villcab.gastos.entitys;

import com.villcab.gastos.utils.model.Entity;
import com.villcab.gastos.utils.model.annotations.Key;
import com.villcab.gastos.utils.model.annotations.TableName;

@TableName(name = "clasificador")
public class Clasificador extends Entity {

    @Key
    private Long id;
    private String descripcion;
    private String valor;

    private Long idTipoClasificador;

    public Clasificador() {
    }

    public Clasificador(Long id, String descripcion, String valor, Long idTipoClasificador) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.idTipoClasificador = idTipoClasificador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getIdTipoClasificador() {
        return idTipoClasificador;
    }

    public void setIdTipoClasificador(Long idTipoClasificador) {
        this.idTipoClasificador = idTipoClasificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clasificador that = (Clasificador) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Clasificador{" +
                "descripcion='" + descripcion + '\'' +
                ", valor='" + valor + '\'' +
                ", idTipoClasificador=" + idTipoClasificador +
                '}';
    }

}
