package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class RealForm implements Serializable {
    private BigDecimal id;

    private BigDecimal realId;

    private String speed;

    private String velocity;

    private String lamar;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getRealId() {
        return realId;
    }

    public void setRealId(BigDecimal realId) {
        this.realId = realId;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed == null ? null : speed.trim();
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity == null ? null : velocity.trim();
    }

    public String getLamar() {
        return lamar;
    }

    public void setLamar(String lamar) {
        this.lamar = lamar == null ? null : lamar.trim();
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
        RealForm other = (RealForm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRealId() == null ? other.getRealId() == null : this.getRealId().equals(other.getRealId()))
            && (this.getSpeed() == null ? other.getSpeed() == null : this.getSpeed().equals(other.getSpeed()))
            && (this.getVelocity() == null ? other.getVelocity() == null : this.getVelocity().equals(other.getVelocity()))
            && (this.getLamar() == null ? other.getLamar() == null : this.getLamar().equals(other.getLamar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRealId() == null) ? 0 : getRealId().hashCode());
        result = prime * result + ((getSpeed() == null) ? 0 : getSpeed().hashCode());
        result = prime * result + ((getVelocity() == null) ? 0 : getVelocity().hashCode());
        result = prime * result + ((getLamar() == null) ? 0 : getLamar().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", realId=").append(realId);
        sb.append(", speed=").append(speed);
        sb.append(", velocity=").append(velocity);
        sb.append(", lamar=").append(lamar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}