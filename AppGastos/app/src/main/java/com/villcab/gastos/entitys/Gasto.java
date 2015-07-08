package com.villcab.gastos.entitys;

import com.villcab.gastos.utils.MyDateUtils;
import com.villcab.gastos.utils.model.Entity;
import com.villcab.gastos.utils.model.annotations.Ignored;
import com.villcab.gastos.utils.model.annotations.Key;
import com.villcab.gastos.utils.model.annotations.TableName;

import java.util.ArrayList;
import java.util.List;

@TableName(name = "gasto")
public class Gasto extends Entity {

    @Key
    private Long id;
    private Long idcTipoGasto;
    private Float total;
    private String detalle;
    private Long fechaRegistro;
    private Long createdBy;

    @Ignored
    private List<DetalleGasto> detalleGastos;

    public Gasto() {
        detalleGastos = new ArrayList<>();
        fechaRegistro = MyDateUtils.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcTipoGasto() {
        return idcTipoGasto;
    }

    public void setIdcTipoGasto(Long idcTipoGasto) {
        this.idcTipoGasto = idcTipoGasto;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Long getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Long fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public List<DetalleGasto> getDetalleGastos() {
        return detalleGastos;
    }

    public void setDetalleGastos(List<DetalleGasto> detalleGastos) {
        this.detalleGastos = detalleGastos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gasto gasto = (Gasto) o;

        return id.equals(gasto.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "id=" + id +
                ", idcTipoGasto=" + idcTipoGasto +
                ", total=" + total +
                ", detalle='" + detalle + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", createdBy=" + createdBy +
                '}';
    }

}
