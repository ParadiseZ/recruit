package org.lanqiao.recruit.domain;

import java.util.Date;

public class person_domain {
    private int pid;
    private  int phone;
    private  String password;
    private  String pname;
    private  String psex;
    private String pborn;
    private  String ptime;
    private  String pstate;
    private  String pschool;
    private  String pmajor;
    private  String exjob;
    private String psrecord;
    private String psal;
    private String padvantage;
    private String pemail;

    public person_domain() {
    }

    public person_domain(int phone, String password, String pname, String psex, String pborn, String ptime, String pstate, String pschool, String pmajor, String exjob, String psrecord, String psal, String padvantage, String pemail) {
        this.phone = phone;
        this.password = password;
        this.pname = pname;
        this.psex = psex;
        this.pborn = pborn;
        this.ptime = ptime;
        this.pstate = pstate;
        this.pschool = pschool;
        this.pmajor = pmajor;
        this.exjob = exjob;
        this.psrecord = psrecord;
        this.psal = psal;
        this.padvantage = padvantage;
        this.pemail = pemail;
    }

    public person_domain(int pid, int phone, String password, String pname, String psex, String pborn, String ptime, String pstate, String pschool, String pmajor, String exjob, String psrecord, String psal, String padvantage, String pemail) {
        this.pid = pid;
        this.phone = phone;
        this.password = password;
        this.pname = pname;
        this.psex = psex;
        this.pborn = pborn;
        this.ptime = ptime;
        this.pstate = pstate;
        this.pschool = pschool;
        this.pmajor = pmajor;
        this.exjob = exjob;
        this.psrecord = psrecord;
        this.psal = psal;
        this.padvantage = padvantage;
        this.pemail = pemail;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPsex() {
        return psex;
    }

    public void setPsex(String psex) {
        this.psex = psex;
    }

    public String getPborn() {
        return pborn;
    }

    public void setPborn(String pborn) {
        this.pborn = pborn;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public String getPschool() {
        return pschool;
    }

    public void setPschool(String pschool) {
        this.pschool = pschool;
    }

    public String getPmajor() {
        return pmajor;
    }

    public void setPmajor(String pmajor) {
        this.pmajor = pmajor;
    }

    public String getExjob() {
        return exjob;
    }

    public void setExjob(String exjob) {
        this.exjob = exjob;
    }

    public String getPsrecord() {
        return psrecord;
    }

    public void setPsrecord(String psrecord) {
        this.psrecord = psrecord;
    }

    public String getPsal() {
        return psal;
    }

    public void setPsal(String psal) {
        this.psal = psal;
    }

    public String getPadvantage() {
        return padvantage;
    }

    public void setPadvantage(String padvantage) {
        this.padvantage = padvantage;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    @Override
    public String toString() {
        return "person_domain{" +
                "pid=" + pid +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", pname='" + pname + '\'' +
                ", psex='" + psex + '\'' +
                ", pborn='" + pborn + '\'' +
                ", ptime='" + ptime + '\'' +
                ", pstate='" + pstate + '\'' +
                ", pschool='" + pschool + '\'' +
                ", pmajor='" + pmajor + '\'' +
                ", exjob='" + exjob + '\'' +
                ", psrecord='" + psrecord + '\'' +
                ", psal='" + psal + '\'' +
                ", padvantage='" + padvantage + '\'' +
                ", pemail='" + pemail + '\'' +
                '}';
    }
}
