package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ComplexForm implements Serializable {
    private BigDecimal id;

    private BigDecimal complexId;

    private String kfreq;

    private String speed;

    private String damping;

    private String frequency;

    private String velocity;

    private String natural;

    private String lamar;

    private String lamai;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getComplexId() {
        return complexId;
    }

    public void setComplexId(BigDecimal complexId) {
        this.complexId = complexId;
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

    public String getDamping() {
        return damping;
    }

    public void setDamping(String damping) {
        this.damping = damping == null ? null : damping.trim();
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

    public String getNatural() {
        return natural;
    }

    public void setNatural(String natural) {
        this.natural = natural == null ? null : natural.trim();
    }

    public String getLamar() {
        return lamar;
    }

    public void setLamar(String lamar) {
        this.lamar = lamar == null ? null : lamar.trim();
    }

    public String getLamai() {
        return lamai;
    }

    public void setLamai(String lamai) {
        this.lamai = lamai == null ? null : lamai.trim();
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
        ComplexForm other = (ComplexForm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComplexId() == null ? other.getComplexId() == null : this.getComplexId().equals(other.getComplexId()))
            && (this.getKfreq() == null ? other.getKfreq() == null : this.getKfreq().equals(other.getKfreq()))
            && (this.getSpeed() == null ? other.getSpeed() == null : this.getSpeed().equals(other.getSpeed()))
            && (this.getDamping() == null ? other.getDamping() == null : this.getDamping().equals(other.getDamping()))
            && (this.getFrequency() == null ? other.getFrequency() == null : this.getFrequency().equals(other.getFrequency()))
            && (this.getVelocity() == null ? other.getVelocity() == null : this.getVelocity().equals(other.getVelocity()))
            && (this.getNatural() == null ? other.getNatural() == null : this.getNatural().equals(other.getNatural()))
            && (this.getLamar() == null ? other.getLamar() == null : this.getLamar().equals(other.getLamar()))
            && (this.getLamai() == null ? other.getLamai() == null : this.getLamai().equals(other.getLamai()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComplexId() == null) ? 0 : getComplexId().hashCode());
        result = prime * result + ((getKfreq() == null) ? 0 : getKfreq().hashCode());
        result = prime * result + ((getSpeed() == null) ? 0 : getSpeed().hashCode());
        result = prime * result + ((getDamping() == null) ? 0 : getDamping().hashCode());
        result = prime * result + ((getFrequency() == null) ? 0 : getFrequency().hashCode());
        result = prime * result + ((getVelocity() == null) ? 0 : getVelocity().hashCode());
        result = prime * result + ((getNatural() == null) ? 0 : getNatural().hashCode());
        result = prime * result + ((getLamar() == null) ? 0 : getLamar().hashCode());
        result = prime * result + ((getLamai() == null) ? 0 : getLamai().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", complexId=").append(complexId);
        sb.append(", kfreq=").append(kfreq);
        sb.append(", speed=").append(speed);
        sb.append(", damping=").append(damping);
        sb.append(", frequency=").append(frequency);
        sb.append(", velocity=").append(velocity);
        sb.append(", natural=").append(natural);
        sb.append(", lamar=").append(lamar);
        sb.append(", lamai=").append(lamai);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}