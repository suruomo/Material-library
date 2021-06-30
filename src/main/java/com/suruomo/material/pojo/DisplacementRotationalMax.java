package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class DisplacementRotationalMax implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private String groupName;

    private String loadcaseName;

    private String subcaseName;

    private String layerName;

    private String r1;

    private String r2;

    private String r3;

    private String magnitude;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getLoadcaseName() {
        return loadcaseName;
    }

    public void setLoadcaseName(String loadcaseName) {
        this.loadcaseName = loadcaseName == null ? null : loadcaseName.trim();
    }

    public String getSubcaseName() {
        return subcaseName;
    }

    public void setSubcaseName(String subcaseName) {
        this.subcaseName = subcaseName == null ? null : subcaseName.trim();
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName == null ? null : layerName.trim();
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

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude == null ? null : magnitude.trim();
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
        DisplacementRotationalMax other = (DisplacementRotationalMax) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getLoadcaseName() == null ? other.getLoadcaseName() == null : this.getLoadcaseName().equals(other.getLoadcaseName()))
            && (this.getSubcaseName() == null ? other.getSubcaseName() == null : this.getSubcaseName().equals(other.getSubcaseName()))
            && (this.getLayerName() == null ? other.getLayerName() == null : this.getLayerName().equals(other.getLayerName()))
            && (this.getR1() == null ? other.getR1() == null : this.getR1().equals(other.getR1()))
            && (this.getR2() == null ? other.getR2() == null : this.getR2().equals(other.getR2()))
            && (this.getR3() == null ? other.getR3() == null : this.getR3().equals(other.getR3()))
            && (this.getMagnitude() == null ? other.getMagnitude() == null : this.getMagnitude().equals(other.getMagnitude()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAnalysisId() == null) ? 0 : getAnalysisId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getLoadcaseName() == null) ? 0 : getLoadcaseName().hashCode());
        result = prime * result + ((getSubcaseName() == null) ? 0 : getSubcaseName().hashCode());
        result = prime * result + ((getLayerName() == null) ? 0 : getLayerName().hashCode());
        result = prime * result + ((getR1() == null) ? 0 : getR1().hashCode());
        result = prime * result + ((getR2() == null) ? 0 : getR2().hashCode());
        result = prime * result + ((getR3() == null) ? 0 : getR3().hashCode());
        result = prime * result + ((getMagnitude() == null) ? 0 : getMagnitude().hashCode());
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
        sb.append(", groupName=").append(groupName);
        sb.append(", loadcaseName=").append(loadcaseName);
        sb.append(", subcaseName=").append(subcaseName);
        sb.append(", layerName=").append(layerName);
        sb.append(", r1=").append(r1);
        sb.append(", r2=").append(r2);
        sb.append(", r3=").append(r3);
        sb.append(", magnitude=").append(magnitude);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}