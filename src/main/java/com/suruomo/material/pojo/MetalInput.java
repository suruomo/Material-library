package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MetalInput implements Serializable {
    private BigDecimal id;

    private String name;

    private String typeName;

    private String family;

    private String specification;

    private String form;

    private String temper;

    private BigDecimal thMin;

    private BigDecimal thMax;

    private String basis;

    private String direction;

    private BigDecimal e;

    private BigDecimal eSec;

    private BigDecimal eC;

    private BigDecimal eCSec;

    private BigDecimal fBru15;

    private BigDecimal fBru20;

    private BigDecimal fBry15;

    private BigDecimal fBry20;

    private BigDecimal fCy;

    private BigDecimal fSu;

    private BigDecimal fTu;

    private BigDecimal fTy;

    private BigDecimal g;

    private BigDecimal nu;

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

    public BigDecimal geteSec() {
        return eSec;
    }

    public void seteSec(BigDecimal eSec) {
        this.eSec = eSec;
    }

    public BigDecimal geteC() {
        return eC;
    }

    public void seteC(BigDecimal eC) {
        this.eC = eC;
    }

    public BigDecimal geteCSec() {
        return eCSec;
    }

    public void seteCSec(BigDecimal eCSec) {
        this.eCSec = eCSec;
    }

    public BigDecimal getfBru15() {
        return fBru15;
    }

    public void setfBru15(BigDecimal fBru15) {
        this.fBru15 = fBru15;
    }

    public BigDecimal getfBru20() {
        return fBru20;
    }

    public void setfBru20(BigDecimal fBru20) {
        this.fBru20 = fBru20;
    }

    public BigDecimal getfBry15() {
        return fBry15;
    }

    public void setfBry15(BigDecimal fBry15) {
        this.fBry15 = fBry15;
    }

    public BigDecimal getfBry20() {
        return fBry20;
    }

    public void setfBry20(BigDecimal fBry20) {
        this.fBry20 = fBry20;
    }

    public BigDecimal getfCy() {
        return fCy;
    }

    public void setfCy(BigDecimal fCy) {
        this.fCy = fCy;
    }

    public BigDecimal getfSu() {
        return fSu;
    }

    public void setfSu(BigDecimal fSu) {
        this.fSu = fSu;
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
        MetalInput other = (MetalInput) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getFamily() == null ? other.getFamily() == null : this.getFamily().equals(other.getFamily()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getForm() == null ? other.getForm() == null : this.getForm().equals(other.getForm()))
            && (this.getTemper() == null ? other.getTemper() == null : this.getTemper().equals(other.getTemper()))
            && (this.getThMin() == null ? other.getThMin() == null : this.getThMin().equals(other.getThMin()))
            && (this.getThMax() == null ? other.getThMax() == null : this.getThMax().equals(other.getThMax()))
            && (this.getBasis() == null ? other.getBasis() == null : this.getBasis().equals(other.getBasis()))
            && (this.getDirection() == null ? other.getDirection() == null : this.getDirection().equals(other.getDirection()))
            && (this.getE() == null ? other.getE() == null : this.getE().equals(other.getE()))
            && (this.geteSec() == null ? other.geteSec() == null : this.geteSec().equals(other.geteSec()))
            && (this.geteC() == null ? other.geteC() == null : this.geteC().equals(other.geteC()))
            && (this.geteCSec() == null ? other.geteCSec() == null : this.geteCSec().equals(other.geteCSec()))
            && (this.getfBru15() == null ? other.getfBru15() == null : this.getfBru15().equals(other.getfBru15()))
            && (this.getfBru20() == null ? other.getfBru20() == null : this.getfBru20().equals(other.getfBru20()))
            && (this.getfBry15() == null ? other.getfBry15() == null : this.getfBry15().equals(other.getfBry15()))
            && (this.getfBry20() == null ? other.getfBry20() == null : this.getfBry20().equals(other.getfBry20()))
            && (this.getfCy() == null ? other.getfCy() == null : this.getfCy().equals(other.getfCy()))
            && (this.getfSu() == null ? other.getfSu() == null : this.getfSu().equals(other.getfSu()))
            && (this.getfTu() == null ? other.getfTu() == null : this.getfTu().equals(other.getfTu()))
            && (this.getfTy() == null ? other.getfTy() == null : this.getfTy().equals(other.getfTy()))
            && (this.getG() == null ? other.getG() == null : this.getG().equals(other.getG()))
            && (this.getNu() == null ? other.getNu() == null : this.getNu().equals(other.getNu()));
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
        result = prime * result + ((getThMin() == null) ? 0 : getThMin().hashCode());
        result = prime * result + ((getThMax() == null) ? 0 : getThMax().hashCode());
        result = prime * result + ((getBasis() == null) ? 0 : getBasis().hashCode());
        result = prime * result + ((getDirection() == null) ? 0 : getDirection().hashCode());
        result = prime * result + ((getE() == null) ? 0 : getE().hashCode());
        result = prime * result + ((geteSec() == null) ? 0 : geteSec().hashCode());
        result = prime * result + ((geteC() == null) ? 0 : geteC().hashCode());
        result = prime * result + ((geteCSec() == null) ? 0 : geteCSec().hashCode());
        result = prime * result + ((getfBru15() == null) ? 0 : getfBru15().hashCode());
        result = prime * result + ((getfBru20() == null) ? 0 : getfBru20().hashCode());
        result = prime * result + ((getfBry15() == null) ? 0 : getfBry15().hashCode());
        result = prime * result + ((getfBry20() == null) ? 0 : getfBry20().hashCode());
        result = prime * result + ((getfCy() == null) ? 0 : getfCy().hashCode());
        result = prime * result + ((getfSu() == null) ? 0 : getfSu().hashCode());
        result = prime * result + ((getfTu() == null) ? 0 : getfTu().hashCode());
        result = prime * result + ((getfTy() == null) ? 0 : getfTy().hashCode());
        result = prime * result + ((getG() == null) ? 0 : getG().hashCode());
        result = prime * result + ((getNu() == null) ? 0 : getNu().hashCode());
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
        sb.append(", thMin=").append(thMin);
        sb.append(", thMax=").append(thMax);
        sb.append(", basis=").append(basis);
        sb.append(", direction=").append(direction);
        sb.append(", e=").append(e);
        sb.append(", eSec=").append(eSec);
        sb.append(", eC=").append(eC);
        sb.append(", eCSec=").append(eCSec);
        sb.append(", fBru15=").append(fBru15);
        sb.append(", fBru20=").append(fBru20);
        sb.append(", fBry15=").append(fBry15);
        sb.append(", fBry20=").append(fBry20);
        sb.append(", fCy=").append(fCy);
        sb.append(", fSu=").append(fSu);
        sb.append(", fTu=").append(fTu);
        sb.append(", fTy=").append(fTy);
        sb.append(", g=").append(g);
        sb.append(", nu=").append(nu);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}