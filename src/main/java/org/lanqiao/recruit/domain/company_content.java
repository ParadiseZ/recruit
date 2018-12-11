package org.lanqiao.recruit.domain;

import java.util.List;

public class company_content {
    private  int id;
    private String title;
    private String titlecon;
    private String twotitle;
    private String twocon;
    private String img;
    private int pid;
    private String belong;
    private List<String> twotitlelist;
    private List<String> twoconlist;

    public List<String> getTwotitlelist() {
        return twotitlelist;
    }

    public void setTwotitlelist(List<String> twotitlelist) {
        this.twotitlelist = twotitlelist;
    }

    public List<String> getTwoconlist() {
        return twoconlist;
    }

    public void setTwoconlist(List<String> twoconlist) {
        this.twoconlist = twoconlist;
    }

    public company_content() {
    }

    public company_content(int id, String title, String titlecon, String twotitle, String twocon, String img, int pid, String belong) {
        this.id = id;
        this.title = title;
        this.titlecon = titlecon;
        this.twotitle = twotitle;
        this.twocon = twocon;
        this.img = img;
        this.pid = pid;
        this.belong = belong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitlecon() {
        return titlecon;
    }

    public void setTitlecon(String titlecon) {
        this.titlecon = titlecon;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    @Override
    public String toString() {
        return "company_content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", titlecon='" + titlecon + '\'' +
                ", twotitle='" + twotitle + '\'' +
                ", twocon='" + twocon + '\'' +
                ", img='" + img + '\'' +
                ", pid=" + pid +
                ", belong='" + belong + '\'' +
                '}';
    }
}
