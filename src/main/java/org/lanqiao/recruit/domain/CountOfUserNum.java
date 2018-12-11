package org.lanqiao.recruit.domain;

public class CountOfUserNum {
    private int pUserNum;
    private int cUserNum;
    private int mUserNum;

    public CountOfUserNum(int pUserNum, int cUserNum, int mUserNum) {
        this.pUserNum = pUserNum;
        this.cUserNum = cUserNum;
        this.mUserNum = mUserNum;
    }

    public CountOfUserNum(int pUserNum) {
        this.pUserNum = pUserNum;
    }

    public int getpUserNum() {
        return pUserNum;
    }

    public void setpUserNum(int pUserNum) {
        this.pUserNum = pUserNum;
    }

    public int getcUserNum() {
        return cUserNum;
    }

    public void setcUserNum(int cUserNum) {
        this.cUserNum = cUserNum;
    }

    public int getmUserNum() {
        return mUserNum;
    }

    public void setmUserNum(int mUserNum) {
        this.mUserNum = mUserNum;
    }

    @Override
    public String toString() {
        return "CountOfUserNum{" +
                "pUserNum=" + pUserNum +
                ", cUserNum=" + cUserNum +
                ", mUserNum=" + mUserNum +
                '}';
    }
}
