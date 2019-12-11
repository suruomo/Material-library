package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Metal implements Serializable {
    private BigDecimal id;

    private String typeName;

    private String family;

    private String specification;

    private String form;

    private String temper;

    private BigDecimal temperature;

    private BigDecimal density;

    private String books;

    private String aircraftid;

    private BigDecimal thMin;

    private BigDecimal thMax;

    private String basis;

    private String direction;

    private BigDecimal e;

    private BigDecimal fSu;

    private BigDecimal eC;

    private BigDecimal fCy;

    private BigDecimal g;

    private BigDecimal nu;

    private BigDecimal fTu;

    private BigDecimal fTy;

    private BigDecimal ra;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family == null ? null : family.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form == null ? null : form.trim();
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper == null ? null : temper.trim();
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getDensity() {
        return density;
    }

    public void setDensity(BigDecimal density) {
        this.density = density;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books == null ? null : books.trim();
    }

    public String getAircraftid() {
        return aircraftid;
    }

    public void setAircraftid(String aircraftid) {
        this.aircraftid = aircraftid == null ? null : aircraftid.trim();
    }

    public BigDecimal getThMin() {
        return thMin;
    }

    public void setThMin(BigDecimal thMin) {
        this.thMin = thMin;
    }

    public BigDecimal getThMax() {
        return thMax;
    }

    public void setThMax(BigDecimal thMax) {
        this.thMax = thMax;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis == null ? null : basis.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public BigDecimal getE() {
        return e;
    }

    public void setE(BigDecimal e) {
        this.e = e;
    }

    public BigDecimal getfSu() {
        return fSu;
    }

    public void setfSu(BigDecimal fSu) {
        this.fSu = fSu;
    }

    public BigDecimal geteC() {
        return eC;
    }

    public void seteC(BigDecimal eC) {
        this.eC = eC;
    }

    public BigDecimal getfCy() {
        return fCy;
    }

    public void setfCy(BigDecimal fCy) {
        this.fCy = fCy;
    }

    public BigDecimal getG() {
        return g;
    }

    public void setG(BigDecimal g) {
        this.g = g;
    }

    public BigDecimal getNu() {
        return nu;
    }

    public void setNu(BigDecimal nu) {
        this.nu = nu;
    }

    public BigDecimal getfTu() {
        return fTu;
    }

    public void setfTu(BigDecimal fTu) {
        this.fTu = fTu;
    }

    public BigDecimal getfTy() {
        return fTy;
    }

    public void setfTy(BigDecimal fTy) {
        this.fTy = fTy;
    }

    public BigDecimal getRa() {
        return ra;
    }

    public void setRa(BigDecimal ra) {
        this.ra = ra;
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
        Metal other = (Metal) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getFamily() == null ? other.getFamily() == null : this.getFamily().equals(other.getFamily()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getForm() == null ? other.getForm() == null : this.getForm().equals(other.getForm()))
            && (this.getTemper() == null ? other.getTemper() == null : this.getTemper().equals(other.getTemper()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getDensity() == null ? other.getDensity() == null : this.getDensity().equals(other.getDensity()))
            && (this.getBooks() == null ? other.getBooks() == null : this.getBooks().equals(other.getBooks()))
            && (this.getAircraftid() == null ? other.getAircraftid() == null : this.getAircraftid().equals(other.getAircraftid()))
            && (this.getThMin() == null ? other.getThMin() == null : this.getThMin().equals(other.getThMin()))
            && (this.getThMax() == null ? other.getThMax() == null : this.getThMax().equals(other.getThMax()))
            && (this.getBasis() == null ? other.getBasis() == null : this.getBasis().equals(other.getBasis()))
            && (this.getDirection() == null ? other.getDirection() == null : this.getDirection().equals(other.getDirection()))
            && (this.getE() == null ? other.getE() == null : this.getE().equals(other.getE()))
            && (this.getfSu() == null ? other.getfSu() == null : this.getfSu().equals(other.getfSu()))
            && (this.geteC() == null ? other.geteC() == null : this.geteC().equals(other.geteC()))
            && (this.getfCy() == null ? other.getfCy() == null : this.getfCy().equals(other.getfCy()))
            && (this.getG() == null ? other.getG() == null : this.getG().equals(other.getG()))
            && (this.getNu() == null ? other.getNu() == null : this.getNu().equals(other.getNu()))
            && (this.getfTu() == null ? other.getfTu() == null : this.getfTu().equals(other.getfTu()))
            && (this.getfTy() == null ? other.getfTy() == null : this.getfTy().equals(other.getfTy()))
            && (this.getRa() == null ? other.getRa() == null : this.getRa().equals(other.getRa()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getFamily() == null) ? 0 : getFamily().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getForm() == null) ? 0 : getForm().hashCode());
        result = prime * result + ((getTemper() == null) ? 0 : getTemper().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getDensity() == null) ? 0 : getDensity().hashCode());
        result = prime * result + ((getBooks() == null) ? 0 : getBooks().hashCode());
        result = prime * result + ((getAircraftid() == null) ? 0 : getAircraftid().hashCode());
        result = prime * result + ((getThMin() == null) ? 0 : getThMin().hashCode());
        result = prime * result + ((getThMax() == null) ? 0 : getThMax().hashCode());
        result = prime * result + ((getBasis() == null) ? 0 : getBasis().hashCode());
        result = prime * result + ((getDirection() == null) ? 0 : getDirection().hashCode());
        result = prime * result + ((getE() == null) ? 0 : getE().hashCode());
        result = prime * result + ((getfSu() == null) ? 0 : getfSu().hashCode());
        result = prime * result + ((geteC() == null) ? 0 : geteC().hashCode());
        result = prime * result + ((getfCy() == null) ? 0 : getfCy().hashCode());
        result = prime * result + ((getG() == null) ? 0 : getG().hashCode());
        result = prime * result + ((getNu() == null) ? 0 : getNu().hashCode());
        result = prime * result + ((getfTu() == null) ? 0 : getfTu().hashCode());
        result = prime * result + ((getfTy() == null) ? 0 : getfTy().hashCode());
        result = prime * result + ((getRa() == null) ? 0 : getRa().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typeName=").append(typeName);
        sb.append(", family=").append(family);
        sb.append(", specification=").append(specification);
        sb.append(", form=").append(form);
        sb.append(", temper=").append(temper);
        sb.append(", temperature=").append(temperature);
        sb.append(", density=").append(density);
        sb.append(", books=").append(books);
        sb.append(", aircraftid=").append(aircraftid);
        sb.append(", thMin=").append(thMin);
        sb.append(", thMax=").append(thMax);
        sb.append(", basis=").append(basis);
        sb.append(", direction=").append(direction);
        sb.append(", e=").append(e);
        sb.append(", fSu=").append(fSu);
        sb.append(", eC=").append(eC);
        sb.append(", fCy=").append(fCy);
        sb.append(", g=").append(g);
        sb.append(", nu=").append(nu);
        sb.append(", fTu=").append(fTu);
        sb.append(", fTy=").append(fTy);
        sb.append(", ra=").append(ra);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}