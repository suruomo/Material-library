package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Layup implements Serializable {
    private String name;

    private String mid;

    private BigDecimal t;

    private String ply;

    private String symmetry;

    private String balance;

    private BigDecimal exx;

    private BigDecimal eyy;

    private BigDecimal gxy;

    private BigDecimal nuxy;

    private BigDecimal nuyx;

    private BigDecimal a11;

    private BigDecimal a22;

    private BigDecimal a12;

    private BigDecimal a66;

    private BigDecimal d11;

    private BigDecimal d22;

    private BigDecimal d12;

    private BigDecimal d66;

    private String pcomp;

    private String aircraft;

    private String remark;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public BigDecimal getT() {
        return t;
    }

    public void setT(BigDecimal t) {
        this.t = t;
    }

    public String getPly() {
        return ply;
    }

    public void setPly(String ply) {
        this.ply = ply == null ? null : ply.trim();
    }

    public String getSymmetry() {
        return symmetry;
    }

    public void setSymmetry(String symmetry) {
        this.symmetry = symmetry == null ? null : symmetry.trim();
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance == null ? null : balance.trim();
    }

    public BigDecimal getExx() {
        return exx;
    }

    public void setExx(BigDecimal exx) {
        this.exx = exx;
    }

    public BigDecimal getEyy() {
        return eyy;
    }

    public void setEyy(BigDecimal eyy) {
        this.eyy = eyy;
    }

    public BigDecimal getGxy() {
        return gxy;
    }

    public void setGxy(BigDecimal gxy) {
        this.gxy = gxy;
    }

    public BigDecimal getNuxy() {
        return nuxy;
    }

    public void setNuxy(BigDecimal nuxy) {
        this.nuxy = nuxy;
    }

    public BigDecimal getNuyx() {
        return nuyx;
    }

    public void setNuyx(BigDecimal nuyx) {
        this.nuyx = nuyx;
    }

    public BigDecimal getA11() {
        return a11;
    }

    public void setA11(BigDecimal a11) {
        this.a11 = a11;
    }

    public BigDecimal getA22() {
        return a22;
    }

    public void setA22(BigDecimal a22) {
        this.a22 = a22;
    }

    public BigDecimal getA12() {
        return a12;
    }

    public void setA12(BigDecimal a12) {
        this.a12 = a12;
    }

    public BigDecimal getA66() {
        return a66;
    }

    public void setA66(BigDecimal a66) {
        this.a66 = a66;
    }

    public BigDecimal getD11() {
        return d11;
    }

    public void setD11(BigDecimal d11) {
        this.d11 = d11;
    }

    public BigDecimal getD22() {
        return d22;
    }

    public void setD22(BigDecimal d22) {
        this.d22 = d22;
    }

    public BigDecimal getD12() {
        return d12;
    }

    public void setD12(BigDecimal d12) {
        this.d12 = d12;
    }

    public BigDecimal getD66() {
        return d66;
    }

    public void setD66(BigDecimal d66) {
        this.d66 = d66;
    }

    public String getPcomp() {
        return pcomp;
    }

    public void setPcomp(String pcomp) {
        this.pcomp = pcomp == null ? null : pcomp.trim();
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft == null ? null : aircraft.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        Layup other = (Layup) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()))
            && (this.getT() == null ? other.getT() == null : this.getT().equals(other.getT()))
            && (this.getPly() == null ? other.getPly() == null : this.getPly().equals(other.getPly()))
            && (this.getSymmetry() == null ? other.getSymmetry() == null : this.getSymmetry().equals(other.getSymmetry()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getExx() == null ? other.getExx() == null : this.getExx().equals(other.getExx()))
            && (this.getEyy() == null ? other.getEyy() == null : this.getEyy().equals(other.getEyy()))
            && (this.getGxy() == null ? other.getGxy() == null : this.getGxy().equals(other.getGxy()))
            && (this.getNuxy() == null ? other.getNuxy() == null : this.getNuxy().equals(other.getNuxy()))
            && (this.getNuyx() == null ? other.getNuyx() == null : this.getNuyx().equals(other.getNuyx()))
            && (this.getA11() == null ? other.getA11() == null : this.getA11().equals(other.getA11()))
            && (this.getA22() == null ? other.getA22() == null : this.getA22().equals(other.getA22()))
            && (this.getA12() == null ? other.getA12() == null : this.getA12().equals(other.getA12()))
            && (this.getA66() == null ? other.getA66() == null : this.getA66().equals(other.getA66()))
            && (this.getD11() == null ? other.getD11() == null : this.getD11().equals(other.getD11()))
            && (this.getD22() == null ? other.getD22() == null : this.getD22().equals(other.getD22()))
            && (this.getD12() == null ? other.getD12() == null : this.getD12().equals(other.getD12()))
            && (this.getD66() == null ? other.getD66() == null : this.getD66().equals(other.getD66()))
            && (this.getPcomp() == null ? other.getPcomp() == null : this.getPcomp().equals(other.getPcomp()))
            && (this.getAircraft() == null ? other.getAircraft() == null : this.getAircraft().equals(other.getAircraft()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMid() == null) ? 0 : getMid().hashCode());
        result = prime * result + ((getT() == null) ? 0 : getT().hashCode());
        result = prime * result + ((getPly() == null) ? 0 : getPly().hashCode());
        result = prime * result + ((getSymmetry() == null) ? 0 : getSymmetry().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getExx() == null) ? 0 : getExx().hashCode());
        result = prime * result + ((getEyy() == null) ? 0 : getEyy().hashCode());
        result = prime * result + ((getGxy() == null) ? 0 : getGxy().hashCode());
        result = prime * result + ((getNuxy() == null) ? 0 : getNuxy().hashCode());
        result = prime * result + ((getNuyx() == null) ? 0 : getNuyx().hashCode());
        result = prime * result + ((getA11() == null) ? 0 : getA11().hashCode());
        result = prime * result + ((getA22() == null) ? 0 : getA22().hashCode());
        result = prime * result + ((getA12() == null) ? 0 : getA12().hashCode());
        result = prime * result + ((getA66() == null) ? 0 : getA66().hashCode());
        result = prime * result + ((getD11() == null) ? 0 : getD11().hashCode());
        result = prime * result + ((getD22() == null) ? 0 : getD22().hashCode());
        result = prime * result + ((getD12() == null) ? 0 : getD12().hashCode());
        result = prime * result + ((getD66() == null) ? 0 : getD66().hashCode());
        result = prime * result + ((getPcomp() == null) ? 0 : getPcomp().hashCode());
        result = prime * result + ((getAircraft() == null) ? 0 : getAircraft().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", mid=").append(mid);
        sb.append(", t=").append(t);
        sb.append(", ply=").append(ply);
        sb.append(", symmetry=").append(symmetry);
        sb.append(", balance=").append(balance);
        sb.append(", exx=").append(exx);
        sb.append(", eyy=").append(eyy);
        sb.append(", gxy=").append(gxy);
        sb.append(", nuxy=").append(nuxy);
        sb.append(", nuyx=").append(nuyx);
        sb.append(", a11=").append(a11);
        sb.append(", a22=").append(a22);
        sb.append(", a12=").append(a12);
        sb.append(", a66=").append(a66);
        sb.append(", d11=").append(d11);
        sb.append(", d22=").append(d22);
        sb.append(", d12=").append(d12);
        sb.append(", d66=").append(d66);
        sb.append(", pcomp=").append(pcomp);
        sb.append(", aircraft=").append(aircraft);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}