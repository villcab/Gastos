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
    private Long productoGuid;
    private Long gastoId;
    private Float total;
    private Long fechaRegistro;

    @Ignored
    private Concepto concepto;
    @Ignored
    private Gasto gasto;

    public DetalleGasto() {
        fechaRegistro = MyDateUtils.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoGuid() {
        return productoGuid;
    }

    public void setProductoGuid(Long productoGuid) {
        this.productoGuid = productoGuid;
    }

    public Long getGastoId() {
        return gastoId;
    }

    public void setGastoId(Long gastoId) {
        this.gastoId = gastoId;
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

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
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
                "fechaRegistro=" + fechaRegistro +
                ", total=" + total +
                ", gastoId=" + gastoId +
                ", productoGuid=" + productoGuid +
                ", id=" + id +
                '}';
    }

}
