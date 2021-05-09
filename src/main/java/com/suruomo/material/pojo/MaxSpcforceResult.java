package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MaxSpcforceResult implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private String t1;

    private String t2;

    private String t3;

    private String r1;

    private String r2;

    private String r3;

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

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1 == null ? null : t1.trim();
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2 == null ? null : t2.trim();
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3 == null ? null : t3.trim();
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1 == null ? null : r1.trim();
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2 == null ? null : r2.trim();
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3 == null ? null : r3.trim();
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
        MaxSpcforceResult other = (MaxSpcforceResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getT1() == null ? other.getT1() == null : this.getT1().equals(other.getT1()))
            && (this.getT2() == null ? other.getT2() == null : this.getT2().equals(other.getT2()))
            && (this.getT3() == null ? other.getT3() == null : this.getT3().equals(other.getT3()))
            && (this.getR1() == null ? other.getR1() == null : this.getR1().equals(other.getR1()))
            && (this.getR2() == null ? other.getR2() == null : this.getR2().equals(other.getR2()))
            && (this.getR3() == null ? other.getR3() == null : this.getR3().equals(other.getR3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAnalysisId() == null) ? 0 : getAnalysisId().hashCode());
        result = prime * result + ((getT1() == null) ? 0 : getT1().hashCode());
        result = prime * result + ((getT2() == null) ? 0 : getT2().hashCode());
        result = prime * result + ((getT3() == null) ? 0 : getT3().hashCode());
        result = prime * result + ((getR1() == null) ? 0 : getR1().hashCode());
        result = prime * result + ((getR2() == null) ? 0 : getR2().hashCode());
        result = prime * result + ((getR3() == null) ? 0 : getR3().hashCode());
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
        sb.append(", t1=").append(t1);
        sb.append(", t2=").append(t2);
        sb.append(", t3=").append(t3);
        sb.append(", r1=").append(r1);
        sb.append(", r2=").append(r2);
        sb.append(", r3=").append(r3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}