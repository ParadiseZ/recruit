package org.lanqiao.recruit.domain;

public class CompanyUser {
    private int id;
    private String userName;
    private String password;
    private long phone;
    private String corporation;
    private String companyName;
    private String email;
    private String job;

    public CompanyUser() {
    }

    public CompanyUser(String userName, String password, long phone, String corporation, String companyName, String email, String job) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.corporation = corporation;
        this.companyName = companyName;
        this.email = email;
        this.job = job;
    }

    public CompanyUser(int id, String userName, String password, long phone, String corporation, String companyName, String email, String job) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.corporation = corporation;
        this.companyName = companyName;
        this.email = email;
        this.job = job;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "CompanyUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", corporation='" + corporation + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
