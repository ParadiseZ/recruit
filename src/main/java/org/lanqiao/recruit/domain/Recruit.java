package org.lanqiao.recruit.domain;

public class Recruit {
    private int id;
    private String job;
    private int neednum;
    private String sal;
    private String location;
    private String companyname;
    private String jobduty;
    private String promulgator;
    private String datatime;

    public Recruit() {
    }

    public Recruit(String job, int neednum, String sal, String location, String companyname, String jobduty, String promulgator, String datatime) {
        this.job = job;
        this.neednum = neednum;
        this.sal = sal;
        this.location = location;
        this.companyname = companyname;
        this.jobduty = jobduty;
        this.promulgator = promulgator;
        this.datatime = datatime;
    }

    public Recruit(int id, String job, int neednum, String sal, String location, String companyname, String jobduty, String promulgator, String datatime) {
        this.id = id;
        this.job = job;
        this.neednum = neednum;
        this.sal = sal;
        this.location = location;
        this.companyname = companyname;
        this.jobduty = jobduty;
        this.promulgator = promulgator;
        this.datatime = datatime;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", neednum=" + neednum +
                ", sal='" + sal + '\'' +
                ", location='" + location + '\'' +
                ", companyname='" + companyname + '\'' +
                ", jobduty='" + jobduty + '\'' +
                ", promulgator='" + promulgator + '\'' +
                ", datatime='" + datatime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getNeednum() {
        return neednum;
    }

    public void setNeednum(int neednum) {
        this.neednum = neednum;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getJobduty() {
        return jobduty;
    }

    public void setJobduty(String jobduty) {
        this.jobduty = jobduty;
    }

    public String getPromulgator() {
        return promulgator;
    }

    public void setPromulgator(String promulgator) {
        this.promulgator = promulgator;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }
}
