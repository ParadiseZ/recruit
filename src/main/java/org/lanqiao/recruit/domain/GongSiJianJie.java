package org.lanqiao.recruit.domain;

public class GongSiJianJie {
    private int pid;
    private String twotitle;//公司简介
    private String twocon;//公司模块内容
    private  String titlecon;//公司模块标题
    private String belong;

    public GongSiJianJie() {
    }

    public GongSiJianJie(String twotitle, String twocon, String titlecon, String belong) {
        this.twotitle = twotitle;
        this.twocon = twocon;
        this.titlecon = titlecon;
        this.belong = belong;
    }

    public GongSiJianJie(int pid, String twotitle, String twocon, String titlecon, String belong) {
        this.pid = pid;
        this.twotitle = twotitle;
        this.twocon = twocon;
        this.titlecon = titlecon;
        this.belong = belong;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTwotitle() {
        return twotitle;
    }

    public void setTwotitle(String twotitle) {
        this.twotitle = twotitle;
    }

    public String getTwocon() {
        return twocon;
    }

    public void setTwocon(String twocon) {
        this.twocon = twocon;
    }

    public String getTitlecon() {
        return titlecon;
    }

    public void setTitlecon(String titlecon) {
        this.titlecon = titlecon;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    @Override
    public String toString() {
        return "GongSiJianJie{" +
                "pid=" + pid +
                ", twotitle='" + twotitle + '\'' +
                ", twocon='" + twocon + '\'' +
                ", titlecon='" + titlecon + '\'' +
                ", belong='" + belong + '\'' +
                '}';
    }
}
