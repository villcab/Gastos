package com.villcab.gastos.entitys;

import com.villcab.gastos.utils.model.Entity;
import com.villcab.gastos.utils.model.annotations.Ignored;
import com.villcab.gastos.utils.model.annotations.Key;
import com.villcab.gastos.utils.model.annotations.TableName;

@TableName(name = "producto")
public class Producto extends Entity {

    @Key
    private Long id;
    private String nombre;
    private String image;
    private Long idcTipoProducto;
    private String code;

    @Ignored
    private Clasificador tipoProducto;

    public Producto() {
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

    public Long getIdcTipoProducto() {
        return idcTipoProducto;
    }

    public void setIdcTipoProducto(Long idcTipoProducto) {
        this.idcTipoProducto = idcTipoProducto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Clasificador getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Clasificador tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;

        return id.equals(producto.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "code='" + code + '\'' +
                ", nombre='" + nombre + '\'' +
                ", image='" + image + '\'' +
                ", idcTipoProducto=" + idcTipoProducto +
                ", tipoProducto=" + tipoProducto +
                '}';
    }

}
