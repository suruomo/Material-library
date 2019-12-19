package com.suruomo.material.dto;

/**
 * MAT8卡片数据传输对象
 * @author 苏若墨
 */

public class Mat8 {
    private String ID;
    private String SOL;
    private String TITLE;
    private int MID;
    private double E1;
    private double E2;
    private double NU12;
    private double RHO;
    private double A1;
    private double TREF;
    private double A2;
    private double G12;
    private double G1Z;
    private double G2Z;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSOL() {
        return SOL;
    }

    public void setSOL(String SOL) {
        this.SOL = SOL;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
    }

    public double getE1() {
        return E1;
    }

    public void setE1(double e1) {
        E1 = e1;
    }

    public double getE2() {
        return E2;
    }

    public void setE2(double e2) {
        E2 = e2;
    }

    public double getNU12() {
        return NU12;
    }

    public void setNU12(double NU12) {
        this.NU12 = NU12;
    }

    public double getRHO() {
        return RHO;
    }

    public void setRHO(double RHO) {
        this.RHO = RHO;
    }

    public double getA1() {
        return A1;
    }

    public void setA1(double a1) {
        A1 = a1;
    }

    public double getTREF() {
        return TREF;
    }

    public void setTREF(double TREF) {
        this.TREF = TREF;
    }

    public double getA2() {
        return A2;
    }

    public void setA2(double a2) {
        A2 = a2;
    }

    public double getG12() {
        return G12;
    }

    public void setG12(double g12) {
        G12 = g12;
    }

    public double getG1Z() {
        return G1Z;
    }

    public void setG1Z(double g1Z) {
        G1Z = g1Z;
    }

    public double getG2Z() {
        return G2Z;
    }

    public void setG2Z(double g2Z) {
        G2Z = g2Z;
    }

    @Override
    public String toString() {
        return "Mat8{" +
                "ID='" + ID + '\'' +
                ", SOL='" + SOL + '\'' +
                ", TITLE='" + TITLE + '\'' +
                ", MID=" + MID +
                ", E1=" + E1 +
                ", E2=" + E2 +
                ", NU12=" + NU12 +
                ", RHO=" + RHO +
                ", A1=" + A1 +
                ", TREF=" + TREF +
                ", A2=" + A2 +
                ", G12=" + G12 +
                ", G1Z=" + G1Z +
                ", G2Z=" + G2Z +
                '}';
    }
}
