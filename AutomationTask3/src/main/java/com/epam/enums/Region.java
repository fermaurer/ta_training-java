package com.epam.enums;

public enum Region {

    IOWA("us-central1", "Iowa (us-central1)"),
    OREGON("us-west1", "Iowa (us-central1)"),
    TAIWAN("asia-east1", "Taiwan (asia-east1)"),
    CAROLINA("us-east1", "South Carolina (us-east1)"),
    NETHERLANDS("europe-west4", "Netherlands (europe-west4)"),
    ALABAMA("us-east7", "Alabama (us-east7");

    private String regionLocator;
    private String regionName;

    private Region(String regionLocator, String regionName){
        this.regionLocator = regionLocator;
        this.regionName = regionName;
    }

    public String getRegionLocator(){
        return regionLocator;
    }
    public String getRegionName(){
        return regionName;
    }



}
