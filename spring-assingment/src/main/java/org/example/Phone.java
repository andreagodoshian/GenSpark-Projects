package org.example;

public class Phone {

    private String mobile;
    private String home;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "{" +
                "mobile=" + mobile +
                ", home=" + home +
                '}';
    }
}
