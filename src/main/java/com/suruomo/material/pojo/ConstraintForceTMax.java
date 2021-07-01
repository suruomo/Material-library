package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ConstraintForceTMax implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private String groupName;

    private String loadcaseName;

    private String subcaseName;

    private String layerName;

    private String t1;

    private String t2;

    private String t3;

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
        ConstraintForceTMax other = (ConstraintForceTMax) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getLoadcaseName() == null ? other.getLoadcaseName() == null : this.getLoadcaseName().equals(other.getLoadcaseName()))
            && (this.getSubcaseName() == null ? other.getSubcaseName() == null : this.getSubcaseName().equals(other.getSubcaseName()))
            && (this.getLayerName() == null ? other.getLayerName() == null : this.getLayerName().equals(other.getLayerName()))
            && (this.getT1() == null ? other.getT1() == null : this.getT1().equals(other.getT1()))
            && (this.getT2() == null ? other.getT2() == null : this.getT2().equals(other.getT2()))
            && (this.getT3() == null ? other.getT3() == null : this.getT3().equals(other.getT3()))
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
        result = prime * result + ((getT1() == null) ? 0 : getT1().hashCode());
        result = prime * result + ((getT2() == null) ? 0 : getT2().hashCode());
        result = prime * result + ((getT3() == null) ? 0 : getT3().hashCode());
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
        sb.append(", t1=").append(t1);
        sb.append(", t2=").append(t2);
        sb.append(", t3=").append(t3);
        sb.append(", magnitude=").append(magnitude);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}