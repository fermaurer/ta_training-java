package com.epam.enums;

public enum Series {

    N1("n1", "N1"),
    A2("a2", "A2"),
    A3("a3", "A3"),
    G2("g2", "G2");
    private String sLocator;
    private String sName;

    private Series(String sLocator, String sName){
        this.sLocator = sLocator;
        this.sName = sName;
    }

    public String getsLocator() {
        return sLocator;
    }

    public String getsName() {
        return sName;
    }




}
