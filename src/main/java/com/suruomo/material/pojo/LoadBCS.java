package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class LoadBCS implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private String loadcaseName;

    private String loadcaseType;

    private String loadId;

    private String loadName;

    private String loadType;

    private String applicationType;

    private String elementDimension;

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

    public String getLoadcaseName() {
        return loadcaseName;
    }

    public void setLoadcaseName(String loadcaseName) {
        this.loadcaseName = loadcaseName == null ? null : loadcaseName.trim();
    }

    public String getLoadcaseType() {
        return loadcaseType;
    }

    public void setLoadcaseType(String loadcaseType) {
        this.loadcaseType = loadcaseType == null ? null : loadcaseType.trim();
    }

    public String getLoadId() {
        return loadId;
    }

    public void setLoadId(String loadId) {
        this.loadId = loadId == null ? null : loadId.trim();
    }

    public String getLoadName() {
        return loadName;
    }

    public void setLoadName(String loadName) {
        this.loadName = loadName == null ? null : loadName.trim();
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType == null ? null : loadType.trim();
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType == null ? null : applicationType.trim();
    }

    public String getElementDimension() {
        return elementDimension;
    }

    public void setElementDimension(String elementDimension) {
        this.elementDimension = elementDimension == null ? null : elementDimension.trim();
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
        LoadBCS other = (LoadBCS) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getLoadcaseName() == null ? other.getLoadcaseName() == null : this.getLoadcaseName().equals(other.getLoadcaseName()))
            && (this.getLoadcaseType() == null ? other.getLoadcaseType() == null : this.getLoadcaseType().equals(other.getLoadcaseType()))
            && (this.getLoadId() == null ? other.getLoadId() == null : this.getLoadId().equals(other.getLoadId()))
            && (this.getLoadName() == null ? other.getLoadName() == null : this.getLoadName().equals(other.getLoadName()))
            && (this.getLoadType() == null ? other.getLoadType() == null : this.getLoadType().equals(other.getLoadType()))
            && (this.getApplicationType() == null ? other.getApplicationType() == null : this.getApplicationType().equals(other.getApplicationType()))
            && (this.getElementDimension() == null ? other.getElementDimension() == null : this.getElementDimension().equals(other.getElementDimension()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAnalysisId() == null) ? 0 : getAnalysisId().hashCode());
        result = prime * result + ((getLoadcaseName() == null) ? 0 : getLoadcaseName().hashCode());
        result = prime * result + ((getLoadcaseType() == null) ? 0 : getLoadcaseType().hashCode());
        result = prime * result + ((getLoadId() == null) ? 0 : getLoadId().hashCode());
        result = prime * result + ((getLoadName() == null) ? 0 : getLoadName().hashCode());
        result = prime * result + ((getLoadType() == null) ? 0 : getLoadType().hashCode());
        result = prime * result + ((getApplicationType() == null) ? 0 : getApplicationType().hashCode());
        result = prime * result + ((getElementDimension() == null) ? 0 : getElementDimension().hashCode());
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
        sb.append(", loadcaseName=").append(loadcaseName);
        sb.append(", loadcaseType=").append(loadcaseType);
        sb.append(", loadId=").append(loadId);
        sb.append(", loadName=").append(loadName);
        sb.append(", loadType=").append(loadType);
        sb.append(", applicationType=").append(applicationType);
        sb.append(", elementDimension=").append(elementDimension);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}