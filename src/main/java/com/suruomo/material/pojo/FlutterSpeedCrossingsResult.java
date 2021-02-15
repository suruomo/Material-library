package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class FlutterSpeedCrossingsResult implements Serializable {
    private BigDecimal id;

    private BigDecimal analysisId;

    private String symmetryType;

    private String machNumber;

    private String density;

    private BigDecimal mode;

    private String kfreq;

    private String speed;

    private String frequency;

    private String velocity;

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

    public String getSymmetryType() {
        return symmetryType;
    }

    public void setSymmetryType(String symmetryType) {
        this.symmetryType = symmetryType == null ? null : symmetryType.trim();
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

    public BigDecimal getMode() {
        return mode;
    }

    public void setMode(BigDecimal mode) {
        this.mode = mode;
    }

    public String getKfreq() {
        return kfreq;
    }

    public void setKfreq(String kfreq) {
        this.kfreq = kfreq == null ? null : kfreq.trim();
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed == null ? null : speed.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity == null ? null : velocity.trim();
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
        FlutterSpeedCrossingsResult other = (FlutterSpeedCrossingsResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getSymmetryType() == null ? other.getSymmetryType() == null : this.getSymmetryType().equals(other.getSymmetryType()))
            && (this.getMachNumber() == null ? other.getMachNumber() == null : this.getMachNumber().equals(other.getMachNumber()))
            && (this.getDensity() == null ? other.getDensity() == null : this.getDensity().equals(other.getDensity()))
            && (this.getMode() == null ? other.getMode() == null : this.getMode().equals(other.getMode()))
            && (this.getKfreq() == null ? other.getKfreq() == null : this.getKfreq().equals(other.getKfreq()))
            && (this.getSpeed() == null ? other.getSpeed() == null : this.getSpeed().equals(other.getSpeed()))
            && (this.getFrequency() == null ? other.getFrequency() == null : this.getFrequency().equals(other.getFrequency()))
            && (this.getVelocity() == null ? other.getVelocity() == null : this.getVelocity().equals(other.getVelocity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAnalysisId() == null) ? 0 : getAnalysisId().hashCode());
        result = prime * result + ((getSymmetryType() == null) ? 0 : getSymmetryType().hashCode());
        result = prime * result + ((getMachNumber() == null) ? 0 : getMachNumber().hashCode());
        result = prime * result + ((getDensity() == null) ? 0 : getDensity().hashCode());
        result = prime * result + ((getMode() == null) ? 0 : getMode().hashCode());
        result = prime * result + ((getKfreq() == null) ? 0 : getKfreq().hashCode());
        result = prime * result + ((getSpeed() == null) ? 0 : getSpeed().hashCode());
        result = prime * result + ((getFrequency() == null) ? 0 : getFrequency().hashCode());
        result = prime * result + ((getVelocity() == null) ? 0 : getVelocity().hashCode());
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
        sb.append(", symmetryType=").append(symmetryType);
        sb.append(", machNumber=").append(machNumber);
        sb.append(", density=").append(density);
        sb.append(", mode=").append(mode);
        sb.append(", kfreq=").append(kfreq);
        sb.append(", speed=").append(speed);
        sb.append(", frequency=").append(frequency);
        sb.append(", velocity=").append(velocity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}