package com.villcab.gastos.entitys;

import com.villcab.gastos.utils.MyDateUtils;
import com.villcab.gastos.utils.model.Entity;
import com.villcab.gastos.utils.model.annotations.Ignored;
import com.villcab.gastos.utils.model.annotations.Key;
import com.villcab.gastos.utils.model.annotations.TableName;

@TableName(name = "detalle_gasto")
public class DetalleGasto extends Entity {

    @Key
    private Long id;
    private Long productoId;
    private Float total;
    private Long fechaRegistro;

    @Ignored
    private Producto producto;

    public DetalleGasto() {
        fechaRegistro = MyDateUtils.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Long getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Long fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleGasto that = (DetalleGasto) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "DetalleGasto{" +
                "id=" + id +
                ", productoId=" + productoId +
                ", total=" + total +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }

}
