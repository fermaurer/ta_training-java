package com.epam.model;

import com.epam.enums.*;

public class ComputeEngine {

    private int instances;
    private OperativeSystems operativeSystem;
    private MachineFamily machineFamily;
    private Series series;
    private MachineType machineType;
    private ProvisioningModel provisioningModel;
    private boolean addGPUs;
    private GPUModel gpuModel;
    private NumberGPUs numberGPUs;
    private LocalSSD localSSD;
    private Region region;
    private CommitedUse commitedUse;

    public ComputeEngine(int instances, OperativeSystems operativeSystem,
                         MachineFamily machineFamily, Series series,
                         MachineType machineType, ProvisioningModel provisioningModel, boolean addGPUs,
                         GPUModel gpuModel, NumberGPUs numberGPUs, LocalSSD localSSD, Region region, CommitedUse commitedUse) {
        this.instances = instances;
        this.operativeSystem = operativeSystem;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.provisioningModel = provisioningModel;
        this.addGPUs = addGPUs;
        this.gpuModel = gpuModel;
        this.numberGPUs = numberGPUs;
        this.localSSD = localSSD;
        this.region = region;
        this.commitedUse = commitedUse;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    public OperativeSystems getOperativeSystem() {
        return operativeSystem;
    }

    public void setOperativeSystem(OperativeSystems operativeSystem) {
        this.operativeSystem = operativeSystem;
    }

    public MachineFamily getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(MachineFamily machineFamily) {
        this.machineFamily = machineFamily;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public ProvisioningModel getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(ProvisioningModel provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public boolean getAddGPUs() {
        return addGPUs;
    }

    public void setAddGPUs(boolean addGPUs) {
        this.addGPUs = addGPUs;
    }

    public GPUModel getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(GPUModel gpuModel) {
        this.gpuModel = gpuModel;
    }

    public NumberGPUs getNumberGPUs() {
        return numberGPUs;
    }

    public void setNumberGPUs(NumberGPUs numberGPUs) {
        this.numberGPUs = numberGPUs;
    }

    public LocalSSD getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(LocalSSD localSSD) {
        this.localSSD = localSSD;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public CommitedUse getCommitedUse() {
        return commitedUse;
    }

    public void setCommitedUse(CommitedUse commitedUse) {
        this.commitedUse = commitedUse;
    }
}
