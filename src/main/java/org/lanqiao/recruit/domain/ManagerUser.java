package org.lanqiao.recruit.domain;

public class ManagerUser {
    private int managerId;
    private String mname;
    private String mpassword;

    public ManagerUser() {
    }

    public ManagerUser(String mname, String mpassword) {
        this.mname = mname;
        this.mpassword = mpassword;
    }

    public ManagerUser(int managerId, String mname, String mpassword) {
        this.managerId = managerId;
        this.mname = mname;
        this.mpassword = mpassword;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    @Override
    public String toString() {
        return "ManagerUser{" +
                "managerId=" + managerId +
                ", mname='" + mname + '\'' +
                ", mpassword='" + mpassword + '\'' +
                '}';
    }
}
