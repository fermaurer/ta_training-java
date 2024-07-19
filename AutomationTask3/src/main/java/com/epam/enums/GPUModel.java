package com.epam.enums;

public enum GPUModel {
    NVIDIA_T4("nvidia-tesla-t4", "NVIDIA T4"),
    NVIDIA_V100("nvidia-tesla-v100", "NVIDIA V100"),
    TESLA_P4("nvidia-tesla-p4", "NVIDIA TESLA P4"),
    TESLA_P100("nvidia-tesla-p100", "NVIDIA TESLA P100"),
    TESLA_K80("nvidia-tesla-k80", "NVIDIA TESLA K80");

    private String gpuLocator;
    private String gpuName;

    private GPUModel(String gpuLocator, String gpuName){
        this.gpuLocator = gpuLocator;
        this.gpuName = gpuName;
    }

    public String getGpuLocator(){
        return gpuLocator;
    }
    public String getGpuName(){
        return gpuName;
    }
}
