package com.epam.enums;

public enum MachineType {
    N1_STANDARD8("n1-standard-8","n1-standard-8, vCPUs: 8, RAM: 30 GB" ),
    F1_MICRO("f1-micro","f1-micro, vCPUs: 1, RAM: 0.9 GB"),
    G1_SMALL("g1-small","g1-small, vCPUs: 1, RAM: 1.7 GB");

    private String mtLocator;
    private String mtName;

    private MachineType(String mtLocator, String mtName){
        this.mtLocator = mtLocator;
        this.mtName = mtName;
    }
    public String getMtLocator(){
        return mtLocator;
    }
    public String getMtName(){
        return mtName;
    }
}
