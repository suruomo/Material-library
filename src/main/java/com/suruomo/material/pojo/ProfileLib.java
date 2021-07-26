package com.suruomo.material.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProfileLib implements Serializable {
    private String pid;

    private Long aid;

    private Long mid;

    private BigDecimal e;

    private BigDecimal g;

    private BigDecimal xc;

    private BigDecimal a;

    private BigDecimal i;

    private byte[] image;

    private static final long serialVersionUID = 1L;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public BigDecimal getE() {
        return e;
    }

    public void setE(BigDecimal e) {
        this.e = e;
    }

    public BigDecimal getG() {
        return g;
    }

    public void setG(BigDecimal g) {
        this.g = g;
    }

    public BigDecimal getXc() {
        return xc;
    }

    public void setXc(BigDecimal xc) {
        this.xc = xc;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getI() {
        return i;
    }

    public void setI(BigDecimal i) {
        this.i = i;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
        ProfileLib other = (ProfileLib) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()))
            && (this.getE() == null ? other.getE() == null : this.getE().equals(other.getE()))
            && (this.getG() == null ? other.getG() == null : this.getG().equals(other.getG()))
            && (this.getXc() == null ? other.getXc() == null : this.getXc().equals(other.getXc()))
            && (this.getA() == null ? other.getA() == null : this.getA().equals(other.getA()))
            && (this.getI() == null ? other.getI() == null : this.getI().equals(other.getI()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getMid() == null) ? 0 : getMid().hashCode());
        result = prime * result + ((getE() == null) ? 0 : getE().hashCode());
        result = prime * result + ((getG() == null) ? 0 : getG().hashCode());
        result = prime * result + ((getXc() == null) ? 0 : getXc().hashCode());
        result = prime * result + ((getA() == null) ? 0 : getA().hashCode());
        result = prime * result + ((getI() == null) ? 0 : getI().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", aid=").append(aid);
        sb.append(", mid=").append(mid);
        sb.append(", e=").append(e);
        sb.append(", g=").append(g);
        sb.append(", xc=").append(xc);
        sb.append(", a=").append(a);
        sb.append(", i=").append(i);
        sb.append(", image=").append(image);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}