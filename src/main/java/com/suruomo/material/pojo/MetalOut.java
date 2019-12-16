package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MetalOut implements Serializable {
    private BigDecimal id;

    private String name;

    private String typeName;

    private String family;

    private String specification;

    private String form;

    private String temper;

    private String matId;

    private BigDecimal rho;

    private String books;

    private String aircraft;

    private BigDecimal fBru;

    private BigDecimal fBry;

    private BigDecimal e;

    private BigDecimal fSu;

    private BigDecimal eC;

    private BigDecimal fCy;

    private BigDecimal g;

    private BigDecimal nu;

    private BigDecimal fTu;

    private BigDecimal fTy;

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

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId == null ? null : matId.trim();
    }

    public BigDecimal getRho() {
        return rho;
    }

    public void setRho(BigDecimal rho) {
        this.rho = rho;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books == null ? null : books.trim();
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft == null ? null : aircraft.trim();
    }

    public BigDecimal getfBru() {
        return fBru;
    }

    public void setfBru(BigDecimal fBru) {
        this.fBru = fBru;
    }

    public BigDecimal getfBry() {
        return fBry;
    }

    public void setfBry(BigDecimal fBry) {
        this.fBry = fBry;
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
        MetalOut other = (MetalOut) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getFamily() == null ? other.getFamily() == null : this.getFamily().equals(other.getFamily()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getForm() == null ? other.getForm() == null : this.getForm().equals(other.getForm()))
            && (this.getTemper() == null ? other.getTemper() == null : this.getTemper().equals(other.getTemper()))
            && (this.getMatId() == null ? other.getMatId() == null : this.getMatId().equals(other.getMatId()))
            && (this.getRho() == null ? other.getRho() == null : this.getRho().equals(other.getRho()))
            && (this.getBooks() == null ? other.getBooks() == null : this.getBooks().equals(other.getBooks()))
            && (this.getAircraft() == null ? other.getAircraft() == null : this.getAircraft().equals(other.getAircraft()))
            && (this.getfBru() == null ? other.getfBru() == null : this.getfBru().equals(other.getfBru()))
            && (this.getfBry() == null ? other.getfBry() == null : this.getfBry().equals(other.getfBry()))
            && (this.getE() == null ? other.getE() == null : this.getE().equals(other.getE()))
            && (this.getfSu() == null ? other.getfSu() == null : this.getfSu().equals(other.getfSu()))
            && (this.geteC() == null ? other.geteC() == null : this.geteC().equals(other.geteC()))
            && (this.getfCy() == null ? other.getfCy() == null : this.getfCy().equals(other.getfCy()))
            && (this.getG() == null ? other.getG() == null : this.getG().equals(other.getG()))
            && (this.getNu() == null ? other.getNu() == null : this.getNu().equals(other.getNu()))
            && (this.getfTu() == null ? other.getfTu() == null : this.getfTu().equals(other.getfTu()))
            && (this.getfTy() == null ? other.getfTy() == null : this.getfTy().equals(other.getfTy()))
            && (this.getA() == null ? other.getA() == null : this.getA().equals(other.getA()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getFamily() == null) ? 0 : getFamily().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getForm() == null) ? 0 : getForm().hashCode());
        result = prime * result + ((getTemper() == null) ? 0 : getTemper().hashCode());
        result = prime * result + ((getMatId() == null) ? 0 : getMatId().hashCode());
        result = prime * result + ((getRho() == null) ? 0 : getRho().hashCode());
        result = prime * result + ((getBooks() == null) ? 0 : getBooks().hashCode());
        result = prime * result + ((getAircraft() == null) ? 0 : getAircraft().hashCode());
        result = prime * result + ((getfBru() == null) ? 0 : getfBru().hashCode());
        result = prime * result + ((getfBry() == null) ? 0 : getfBry().hashCode());
        result = prime * result + ((getE() == null) ? 0 : getE().hashCode());
        result = prime * result + ((getfSu() == null) ? 0 : getfSu().hashCode());
        result = prime * result + ((geteC() == null) ? 0 : geteC().hashCode());
        result = prime * result + ((getfCy() == null) ? 0 : getfCy().hashCode());
        result = prime * result + ((getG() == null) ? 0 : getG().hashCode());
        result = prime * result + ((getNu() == null) ? 0 : getNu().hashCode());
        result = prime * result + ((getfTu() == null) ? 0 : getfTu().hashCode());
        result = prime * result + ((getfTy() == null) ? 0 : getfTy().hashCode());
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
        sb.append(", typeName=").append(typeName);
        sb.append(", family=").append(family);
        sb.append(", specification=").append(specification);
        sb.append(", form=").append(form);
        sb.append(", temper=").append(temper);
        sb.append(", matId=").append(matId);
        sb.append(", rho=").append(rho);
        sb.append(", books=").append(books);
        sb.append(", aircraft=").append(aircraft);
        sb.append(", fBru=").append(fBru);
        sb.append(", fBry=").append(fBry);
        sb.append(", e=").append(e);
        sb.append(", fSu=").append(fSu);
        sb.append(", eC=").append(eC);
        sb.append(", fCy=").append(fCy);
        sb.append(", g=").append(g);
        sb.append(", nu=").append(nu);
        sb.append(", fTu=").append(fTu);
        sb.append(", fTy=").append(fTy);
        sb.append(", a=").append(a);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}