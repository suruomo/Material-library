package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CompositeOut implements Serializable {
    private BigDecimal id;

    private String name;

    private String matId;

    private BigDecimal temperature;

    private BigDecimal thickness;

    private BigDecimal rho;

    private String aircraft;

    private BigDecimal e1;

    private BigDecimal e2;

    private BigDecimal nu12;

    private BigDecimal g12;

    private BigDecimal g1z;

    private BigDecimal g2z;

    private BigDecimal a;

    private String remark;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId == null ? null : matId.trim();
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getThickness() {
        return thickness;
    }

    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    public BigDecimal getRho() {
        return rho;
    }

    public void setRho(BigDecimal rho) {
        this.rho = rho;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft == null ? null : aircraft.trim();
    }

    public BigDecimal getE1() {
        return e1;
    }

    public void setE1(BigDecimal e1) {
        this.e1 = e1;
    }

    public BigDecimal getE2() {
        return e2;
    }

    public void setE2(BigDecimal e2) {
        this.e2 = e2;
    }

    public BigDecimal getNu12() {
        return nu12;
    }

    public void setNu12(BigDecimal nu12) {
        this.nu12 = nu12;
    }

    public BigDecimal getG12() {
        return g12;
    }

    public void setG12(BigDecimal g12) {
        this.g12 = g12;
    }

    public BigDecimal getG1z() {
        return g1z;
    }

    public void setG1z(BigDecimal g1z) {
        this.g1z = g1z;
    }

    public BigDecimal getG2z() {
        return g2z;
    }

    public void setG2z(BigDecimal g2z) {
        this.g2z = g2z;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CompositeOut other = (CompositeOut) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMatId() == null ? other.getMatId() == null : this.getMatId().equals(other.getMatId()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getThickness() == null ? other.getThickness() == null : this.getThickness().equals(other.getThickness()))
            && (this.getRho() == null ? other.getRho() == null : this.getRho().equals(other.getRho()))
            && (this.getAircraft() == null ? other.getAircraft() == null : this.getAircraft().equals(other.getAircraft()))
            && (this.getE1() == null ? other.getE1() == null : this.getE1().equals(other.getE1()))
            && (this.getE2() == null ? other.getE2() == null : this.getE2().equals(other.getE2()))
            && (this.getNu12() == null ? other.getNu12() == null : this.getNu12().equals(other.getNu12()))
            && (this.getG12() == null ? other.getG12() == null : this.getG12().equals(other.getG12()))
            && (this.getG1z() == null ? other.getG1z() == null : this.getG1z().equals(other.getG1z()))
            && (this.getG2z() == null ? other.getG2z() == null : this.getG2z().equals(other.getG2z()))
            && (this.getA() == null ? other.getA() == null : this.getA().equals(other.getA()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMatId() == null) ? 0 : getMatId().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getThickness() == null) ? 0 : getThickness().hashCode());
        result = prime * result + ((getRho() == null) ? 0 : getRho().hashCode());
        result = prime * result + ((getAircraft() == null) ? 0 : getAircraft().hashCode());
        result = prime * result + ((getE1() == null) ? 0 : getE1().hashCode());
        result = prime * result + ((getE2() == null) ? 0 : getE2().hashCode());
        result = prime * result + ((getNu12() == null) ? 0 : getNu12().hashCode());
        result = prime * result + ((getG12() == null) ? 0 : getG12().hashCode());
        result = prime * result + ((getG1z() == null) ? 0 : getG1z().hashCode());
        result = prime * result + ((getG2z() == null) ? 0 : getG2z().hashCode());
        result = prime * result + ((getA() == null) ? 0 : getA().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", matId=").append(matId);
        sb.append(", temperature=").append(temperature);
        sb.append(", thickness=").append(thickness);
        sb.append(", rho=").append(rho);
        sb.append(", aircraft=").append(aircraft);
        sb.append(", e1=").append(e1);
        sb.append(", e2=").append(e2);
        sb.append(", nu12=").append(nu12);
        sb.append(", g12=").append(g12);
        sb.append(", g1z=").append(g1z);
        sb.append(", g2z=").append(g2z);
        sb.append(", a=").append(a);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}