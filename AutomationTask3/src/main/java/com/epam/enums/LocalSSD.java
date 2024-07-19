package com.epam.enums;

public enum LocalSSD {
    ZERO("1", "0"),
    ONE375("2","1x375 GB" ),
    TWO375("3", "2x375 GB"),
    THREE375("4", "3x375 GB"),
    FOUR375("5", "4x375 GB"),
    FIVE375("6","5x375 GB" );

    private String SDDLocator;
    private String SDDName;

    private LocalSSD(String SDDLocator, String SDDName){
        this.SDDLocator = SDDLocator;
        this.SDDName = SDDName;
    }

    public String getSDDLocator(){
        return SDDLocator;
    }
    public String getSDDName(){
        return SDDName;
    }
}
