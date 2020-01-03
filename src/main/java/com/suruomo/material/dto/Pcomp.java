package com.suruomo.material.dto;

/**
 * PCOMP卡片数据传输对象
 * @author 苏若墨
 */
public class Pcomp {
    private String ID;
    private String SOL;
    private String TITLE;
    private int PID;
    private String FT;
    private String LAM;
    private String SOUT;
    private String DATA;

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

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getFT() {
        return FT;
    }

    public void setFT(String FT) {
        this.FT = FT;
    }

    public String getLAM() {
        return LAM;
    }

    public void setLAM(String LAM) {
        this.LAM = LAM;
    }

    public String getSOUT() {
        return SOUT;
    }

    public void setSOUT(String SOUT) {
        this.SOUT = SOUT;
    }

    public String getDATA() {
        return DATA;
    }

    public void setDATA(String DATA) {
        this.DATA = DATA;
    }

    @Override
    public String toString() {
        return "Pcomp{" +
                "ID='" + ID + '\'' +
                ", SOL='" + SOL + '\'' +
                ", TITLE='" + TITLE + '\'' +
                ", PID=" + PID +
                ", FT='" + FT + '\'' +
                ", LAM='" + LAM + '\'' +
                ", SOUT='" + SOUT + '\'' +
                ", DATA='" + DATA + '\'' +
                '}';
    }
}
