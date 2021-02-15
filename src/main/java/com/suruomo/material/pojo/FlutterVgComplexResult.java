package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class FlutterVgComplexResult implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private BigDecimal mode;

    private String machNumber;

    private String density;

    private String symmetryType;

    private String flutterMethod;

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

    public BigDecimal getMode() {
        return mode;
    }

    public void setMode(BigDecimal mode) {
        this.mode = mode;
    }

    public String getMachNumber() {
        return machNumber;
    }

    public void setMachNumber(String machNumber) {
        this.machNumber = machNumber == null ? null : machNumber.trim();
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density == null ? null : density.trim();
    }

    public String getSymmetryType() {
        return symmetryType;
    }

    public void setSymmetryType(String symmetryType) {
        this.symmetryType = symmetryType == null ? null : symmetryType.trim();
    }

    public String getFlutterMethod() {
        return flutterMethod;
    }

    public void setFlutterMethod(String flutterMethod) {
        this.flutterMethod = flutterMethod == null ? null : flutterMethod.trim();
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
        FlutterVgComplexResult other = (FlutterVgComplexResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getMode() == null ? other.getMode() == null : this.getMode().equals(other.getMode()))
            && (this.getMachNumber() == null ? other.getMachNumber() == null : this.getMachNumber().equals(other.getMachNumber()))
            && (this.getDensity() == null ? other.getDensity() == null : this.getDensity().equals(other.getDensity()))
            && (this.getSymmetryType() == null ? other.getSymmetryType() == null : this.getSymmetryType().equals(other.getSymmetryType()))
            && (this.getFlutterMethod() == null ? other.getFlutterMethod() == null : this.getFlutterMethod().equals(other.getFlutterMethod()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAnalysisId() == null) ? 0 : getAnalysisId().hashCode());
        result = prime * result + ((getMode() == null) ? 0 : getMode().hashCode());
        result = prime * result + ((getMachNumber() == null) ? 0 : getMachNumber().hashCode());
        result = prime * result + ((getDensity() == null) ? 0 : getDensity().hashCode());
        result = prime * result + ((getSymmetryType() == null) ? 0 : getSymmetryType().hashCode());
        result = prime * result + ((getFlutterMethod() == null) ? 0 : getFlutterMethod().hashCode());
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
        sb.append(", mode=").append(mode);
        sb.append(", machNumber=").append(machNumber);
        sb.append(", density=").append(density);
        sb.append(", symmetryType=").append(symmetryType);
        sb.append(", flutterMethod=").append(flutterMethod);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}