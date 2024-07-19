package com.epam.enums;

public enum ProvisioningModel {

    REGULAR("107regular", "Regular"),
    SPOT("107spot", "Spot (Preemptible VM)");

    private String pmLocator;
    private String pmName;

    private ProvisioningModel(String pmLocator, String pmName) {
        this.pmLocator = pmLocator;
        this.pmName = pmName;
    }
    public String getProvisioningModel(){
         return pmLocator;
        }

    public String getPmName(){
        return pmName;
    }

}

