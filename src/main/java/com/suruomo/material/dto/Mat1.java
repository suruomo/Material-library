package com.suruomo.material.dto;

/**
 * MAT1卡片数据传输对象
 * @author 苏若墨
 */
public class Mat1 {
    private String ID;
    private String SOL;
    private String TITLE;
    private int MID;
    private double E;
    private double G;
    private double NU;
    private double RHO;
    private double A;
    private double TREF;
    private double GE;
    private double ST;
    private double SC;
    private double SS;
    private int MCSID;

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

    public double getE() {
        return E;
    }

    public void setE(double e) {
        E = e;
    }

    public double getG() {
        return G;
    }

    public void setG(double g) {
        G = g;
    }

    public double getNU() {
        return NU;
    }

    public void setNU(double NU) {
        this.NU = NU;
    }

    public double getRHO() {
        return RHO;
    }

    public void setRHO(double RHO) {
        this.RHO = RHO;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getTREF() {
        return TREF;
    }

    public void setTREF(double TREF) {
        this.TREF = TREF;
    }

    public double getGE() {
        return GE;
    }

    public void setGE(double GE) {
        this.GE = GE;
    }

    public double getST() {
        return ST;
    }

    public void setST(double ST) {
        this.ST = ST;
    }

    public double getSC() {
        return SC;
    }

    public void setSC(double SC) {
        this.SC = SC;
    }

    public double getSS() {
        return SS;
    }

    public void setSS(double SS) {
        this.SS = SS;
    }

    public int getMCSID() {
        return MCSID;
    }

    @Override
    public String toString() {
        return "Mat1{" +
                "ID='" + ID + '\'' +
                ", SOL='" + SOL + '\'' +
                ", TITLE='" + TITLE + '\'' +
                ", MID=" + MID +
                ", E=" + E +
                ", G=" + G +
                ", NU=" + NU +
                ", RHO=" + RHO +
                ", A=" + A +
                ", TREF=" + TREF +
                ", GE=" + GE +
                ", ST=" + ST +
                ", SC=" + SC +
                ", SS=" + SS +
                ", MCSID=" + MCSID +
                '}';
    }

    public void setMCSID(int MCSID) {
        this.MCSID = MCSID;
    }
}
