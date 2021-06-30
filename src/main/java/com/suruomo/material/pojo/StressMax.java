package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class StressMax implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private String groupName;

    private String loadcaseName;

    private String subcaseName;

    private String layerName;

    private String x;

    private String y;

    private String z;

    private String xy;

    private String yz;

    private String zx;

    private String vonMises;

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

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x == null ? null : x.trim();
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y == null ? null : y.trim();
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z == null ? null : z.trim();
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy == null ? null : xy.trim();
    }

    public String getYz() {
        return yz;
    }

    public void setYz(String yz) {
        this.yz = yz == null ? null : yz.trim();
    }

    public String getZx() {
        return zx;
    }

    public void setZx(String zx) {
        this.zx = zx == null ? null : zx.trim();
    }

    public String getVonMises() {
        return vonMises;
    }

    public void setVonMises(String vonMises) {
        this.vonMises = vonMises == null ? null : vonMises.trim();
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
        StressMax other = (StressMax) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getLoadcaseName() == null ? other.getLoadcaseName() == null : this.getLoadcaseName().equals(other.getLoadcaseName()))
            && (this.getSubcaseName() == null ? other.getSubcaseName() == null : this.getSubcaseName().equals(other.getSubcaseName()))
            && (this.getLayerName() == null ? other.getLayerName() == null : this.getLayerName().equals(other.getLayerName()))
            && (this.getX() == null ? other.getX() == null : this.getX().equals(other.getX()))
            && (this.getY() == null ? other.getY() == null : this.getY().equals(other.getY()))
            && (this.getZ() == null ? other.getZ() == null : this.getZ().equals(other.getZ()))
            && (this.getXy() == null ? other.getXy() == null : this.getXy().equals(other.getXy()))
            && (this.getYz() == null ? other.getYz() == null : this.getYz().equals(other.getYz()))
            && (this.getZx() == null ? other.getZx() == null : this.getZx().equals(other.getZx()))
            && (this.getVonMises() == null ? other.getVonMises() == null : this.getVonMises().equals(other.getVonMises()));
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
        result = prime * result + ((getX() == null) ? 0 : getX().hashCode());
        result = prime * result + ((getY() == null) ? 0 : getY().hashCode());
        result = prime * result + ((getZ() == null) ? 0 : getZ().hashCode());
        result = prime * result + ((getXy() == null) ? 0 : getXy().hashCode());
        result = prime * result + ((getYz() == null) ? 0 : getYz().hashCode());
        result = prime * result + ((getZx() == null) ? 0 : getZx().hashCode());
        result = prime * result + ((getVonMises() == null) ? 0 : getVonMises().hashCode());
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
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append(", xy=").append(xy);
        sb.append(", yz=").append(yz);
        sb.append(", zx=").append(zx);
        sb.append(", vonMises=").append(vonMises);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}