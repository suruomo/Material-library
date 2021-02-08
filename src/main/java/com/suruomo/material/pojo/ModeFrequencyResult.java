package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ModeFrequencyResult implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private BigDecimal modeNo;

    private BigDecimal modeOrder;

    private String e;

    private String r;

    private String c;

    private String mass;

    private String stiffness;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(BigDecimal analysisId) {
        this.analysisId = analysisId;
    }

    public BigDecimal getModeNo() {
        return modeNo;
    }

    public void setModeNo(BigDecimal modeNo) {
        this.modeNo = modeNo;
    }

    public BigDecimal getModeOrder() {
        return modeOrder;
    }

    public void setModeOrder(BigDecimal modeOrder) {
        this.modeOrder = modeOrder;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e == null ? null : e.trim();
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r == null ? null : r.trim();
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c == null ? null : c.trim();
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass == null ? null : mass.trim();
    }

    public String getStiffness() {
        return stiffness;
    }

    public void setStiffness(String stiffness) {
        this.stiffness = stiffness == null ? null : stiffness.trim();
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
        ModeFrequencyResult other = (ModeFrequencyResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getModeNo() == null ? other.getModeNo() == null : this.getModeNo().equals(other.getModeNo()))
            && (this.getModeOrder() == null ? other.getModeOrder() == null : this.getModeOrder().equals(other.getModeOrder()))
            && (this.getE() == null ? other.getE() == null : this.getE().equals(other.getE()))
            && (this.getR() == null ? other.getR() == null : this.getR().equals(other.getR()))
            && (this.getC() == null ? other.getC() == null : this.getC().equals(other.getC()))
            && (this.getMass() == null ? other.getMass() == null : this.getMass().equals(other.getMass()))
            && (this.getStiffness() == null ? other.getStiffness() == null : this.getStiffness().equals(other.getStiffness()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAnalysisId() == null) ? 0 : getAnalysisId().hashCode());
        result = prime * result + ((getModeNo() == null) ? 0 : getModeNo().hashCode());
        result = prime * result + ((getModeOrder() == null) ? 0 : getModeOrder().hashCode());
        result = prime * result + ((getE() == null) ? 0 : getE().hashCode());
        result = prime * result + ((getR() == null) ? 0 : getR().hashCode());
        result = prime * result + ((getC() == null) ? 0 : getC().hashCode());
        result = prime * result + ((getMass() == null) ? 0 : getMass().hashCode());
        result = prime * result + ((getStiffness() == null) ? 0 : getStiffness().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", analysisId=").append(analysisId);
        sb.append(", modeNo=").append(modeNo);
        sb.append(", modeOrder=").append(modeOrder);
        sb.append(", e=").append(e);
        sb.append(", r=").append(r);
        sb.append(", c=").append(c);
        sb.append(", mass=").append(mass);
        sb.append(", stiffness=").append(stiffness);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}