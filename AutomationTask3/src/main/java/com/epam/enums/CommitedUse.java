package com.epam.enums;

public enum CommitedUse {
    NONE("116none", "None"),
    ONE_YEAR("1161-year", "1 year"),
    THREE_YEARS("1163-years", "3 years");

    private String cuLocator;
    private String cuName;

    private CommitedUse(String cuLocator, String cuName){
        this.cuLocator = cuLocator;
        this.cuName = cuName;
    }

    public String getCuLocator() {
        return cuLocator;
    }
    public String getCuName() {
        return cuName;
    }
}
