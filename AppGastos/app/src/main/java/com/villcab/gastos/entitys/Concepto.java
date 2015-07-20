package com.villcab.gastos.entitys;

import com.villcab.gastos.utils.model.Entity;
import com.villcab.gastos.utils.model.annotations.Ignored;
import com.villcab.gastos.utils.model.annotations.Key;
import com.villcab.gastos.utils.model.annotations.TableName;

@TableName(name = "concepto")
public class Concepto extends Entity {

    @Key
    private Long id;
    private String nombre;
    private String image;
    private Long idCategoria;
    private String guid;

    @Ignored
    private Categoria categoria;

    public Concepto() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Concepto concepto = (Concepto) o;

        return id.equals(concepto.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Concepto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", image='" + image + '\'' +
                ", idCategoria=" + idCategoria +
                ", guid='" + guid + '\'' +
                '}';
    }

}
