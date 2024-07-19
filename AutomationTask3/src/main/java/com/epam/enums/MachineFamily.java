package com.epam.enums;

public enum MachineFamily {
    GENERAL("general-purpose", "General Purpose"),
    COMPUTE("compute-optimized", "Compute-optimized"),
    MEMORY("memory-optimized", "Memory-optimized"),
    ACCELERATOR("accelerator-optimized", "Accelerator-optimized"),
    STORAGE("storage-optimized", "Storage-optimized");

    private String mfLocator;

    private String mfName;

    private MachineFamily(String mfLocator, String mfName) {
        this.mfLocator = mfLocator;
        this.mfName = mfName;
    }

    public String getMfLocator() {
        return mfLocator;
    }

    public String getMfName() {
        return mfName;
    }
}

