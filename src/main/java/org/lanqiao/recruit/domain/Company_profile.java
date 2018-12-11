package org.lanqiao.recruit.domain;

public class Company_profile {
    private int id;
    private String company;
    private String aboutus;
    private String companynews;
    private String joinus;
    private String contactus;
    private String links;
    private String logo;
    private int pid;

    public Company_profile() {
    }

    public Company_profile(int id, String company, String aboutus, String companynews, String joinus, String contactus, String links, String logo, int pid) {
        this.id = id;
        this.company = company;
        this.aboutus = aboutus;
        this.companynews = companynews;
        this.joinus = joinus;
        this.contactus = contactus;
        this.links = links;
        this.logo = logo;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAboutus() {
        return aboutus;
    }

    public void setAboutus(String aboutus) {
        this.aboutus = aboutus;
    }

    public String getCompanynews() {
        return companynews;
    }

    public void setCompanynews(String companynews) {
        this.companynews = companynews;
    }

    public String getJoinus() {
        return joinus;
    }

    public void setJoinus(String joinus) {
        this.joinus = joinus;
    }

    public String getContactus() {
        return contactus;
    }

    public void setContactus(String contactus) {
        this.contactus = contactus;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Company_profile{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", aboutus='" + aboutus + '\'' +
                ", companynews='" + companynews + '\'' +
                ", joinus='" + joinus + '\'' +
                ", contactus='" + contactus + '\'' +
                ", links='" + links + '\'' +
                ", logo='" + logo + '\'' +
                ", pid=" + pid +
                '}';
    }
}
