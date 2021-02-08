package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GridStrainResult implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private BigDecimal elementId;

    private BigDecimal pointId;

    private BigDecimal elementCenter;

    private String x;

    private String y;

    private String z;

    private String xy;

    private String yz;

    private String zx;

    private String meanPressure;

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

    public BigDecimal getElementId() {
        return elementId;
    }

    public void setElementId(BigDecimal elementId) {
        this.elementId = elementId;
    }

    public BigDecimal getPointId() {
        return pointId;
    }

    public void setPointId(BigDecimal pointId) {
        this.pointId = pointId;
    }

    public BigDecimal getElementCenter() {
        return elementCenter;
    }

    public void setElementCenter(BigDecimal elementCenter) {
        this.elementCenter = elementCenter;
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

    public String getMeanPressure() {
        return meanPressure;
    }

    public void setMeanPressure(String meanPressure) {
        this.meanPressure = meanPressure == null ? null : meanPressure.trim();
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
        GridStrainResult other = (GridStrainResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getElementId() == null ? other.getElementId() == null : this.getElementId().equals(other.getElementId()))
            && (this.getPointId() == null ? other.getPointId() == null : this.getPointId().equals(other.getPointId()))
            && (this.getElementCenter() == null ? other.getElementCenter() == null : this.getElementCenter().equals(other.getElementCenter()))
            && (this.getX() == null ? other.getX() == null : this.getX().equals(other.getX()))
            && (this.getY() == null ? other.getY() == null : this.getY().equals(other.getY()))
            && (this.getZ() == null ? other.getZ() == null : this.getZ().equals(other.getZ()))
            && (this.getXy() == null ? other.getXy() == null : this.getXy().equals(other.getXy()))
            && (this.getYz() == null ? other.getYz() == null : this.getYz().equals(other.getYz()))
            && (this.getZx() == null ? other.getZx() == null : this.getZx().equals(other.getZx()))
            && (this.getMeanPressure() == null ? other.getMeanPressure() == null : this.getMeanPressure().equals(other.getMeanPressure()))
            && (this.getVonMises() == null ? other.getVonMises() == null : this.getVonMises().equals(other.getVonMises()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAnalysisId() == null) ? 0 : getAnalysisId().hashCode());
        result = prime * result + ((getElementId() == null) ? 0 : getElementId().hashCode());
        result = prime * result + ((getPointId() == null) ? 0 : getPointId().hashCode());
        result = prime * result + ((getElementCenter() == null) ? 0 : getElementCenter().hashCode());
        result = prime * result + ((getX() == null) ? 0 : getX().hashCode());
        result = prime * result + ((getY() == null) ? 0 : getY().hashCode());
        result = prime * result + ((getZ() == null) ? 0 : getZ().hashCode());
        result = prime * result + ((getXy() == null) ? 0 : getXy().hashCode());
        result = prime * result + ((getYz() == null) ? 0 : getYz().hashCode());
        result = prime * result + ((getZx() == null) ? 0 : getZx().hashCode());
        result = prime * result + ((getMeanPressure() == null) ? 0 : getMeanPressure().hashCode());
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
        sb.append(", elementId=").append(elementId);
        sb.append(", pointId=").append(pointId);
        sb.append(", elementCenter=").append(elementCenter);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append(", xy=").append(xy);
        sb.append(", yz=").append(yz);
        sb.append(", zx=").append(zx);
        sb.append(", meanPressure=").append(meanPressure);
        sb.append(", vonMises=").append(vonMises);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}