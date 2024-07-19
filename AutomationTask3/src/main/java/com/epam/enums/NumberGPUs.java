package com.epam.enums;

public enum NumberGPUs {

    GPU1("1", "1"),
    GPU2("2", "2"),
    GPU4("4", "4"),
    GPU8("8", "8");

    private String gpusLocator;
    private String gpusNumber;

    private NumberGPUs(String gpusLocator, String gpusNumber){
        this.gpusLocator = gpusLocator;
        this.gpusNumber = gpusNumber;
    }

    public String getGpusLocator(){
        return gpusLocator;
    }

    public String getGpusNumber(){
        return gpusNumber;
    }
}
