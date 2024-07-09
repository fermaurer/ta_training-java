package com.epam;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

/**
 * Represents the Compute Engine Page of Google Cloud Calculator
 * Extends {@link BasePage} to initialize WebDriver and WebElements
 */
public class ComputeEnginePage extends BasePage {


    @FindBy(xpath = "//label[@for='c13']")
    private WebElement numberInstances;

    @FindBy(xpath = "//span[@id='c24']/following-sibling::div")
    private WebElement operatingSystem;

    @FindBy(xpath = "//li[@data-value='free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license']")
    private WebElement operatingSystemOption;

    @FindBy(xpath = "//label[@for='regular']")
    private WebElement provisioningModel;

    @FindBy(xpath = "//span[@id='c28']/following-sibling::div")
    private WebElement machineFamily;

    @FindBy(xpath = "//li[@data-value='general-purpose']")
    private WebElement selectMachineFamily;

    @FindBy(xpath = "//span[@id='c32']/following-sibling::div")
    private WebElement openSeries;

    @FindBy(xpath = "//li[@data-value='n1']")
    private WebElement selectSeries;

    @FindBy(xpath = "//span[@id='c36']/following-sibling::div")
    private WebElement machineType;

    @FindBy(xpath = "//li[@data-value='n1-standard-8']")
    private WebElement selectMachineType;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement gpuButton;

    @FindBy(css = "div.VfPpkd-aPP78e")
    private List<WebElement> listOfGPU;

    @FindBy(xpath = "//li[@data-value='nvidia-tesla-v100']")
    private WebElement selectGpuType;

    @FindBy(css = "div.VfPpkd-aPP78e")
    private List<WebElement> listNumberOfGPU;

    @FindBy(xpath = "//li[@data-value='1']")
    private WebElement selectNumberOfGpu;

    @FindBy(xpath = "//span[@id='c44']/following-sibling::div")
    private WebElement localSSD;

    @FindBy(xpath = "//ul[@aria-label='Local SSD']/li[3]")
    private WebElement selectLocalSSD;

    @FindBy(xpath = "//span[@id='c48']/following-sibling::div")
    private WebElement region;

    @FindBy(xpath = "//li[@data-value='europe-west4']")
    private WebElement selectRegion;

    @FindBy(xpath = "//label[@for='1-year']")
    private WebElement commitedUse;

    @FindBy(xpath = "//span[@class='FOBRw-vQzf8d']")
    private WebElement share;

    @FindBy(xpath = "//div[contains(@class,'Z7Qi9d') and contains(@class, ' HY0Uh')]")
    private WebElement updateMessage;

    /**
     * Constructor to initialize ComputeEnginePage with the WebDriver.
     * @param driver WebDriver instance to be used for interacting with the web elements.
     */
    public ComputeEnginePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets the number of instances
     * @param instances the number of instances to be set.
     */

    public void setNumberOfInstances(int instances) {
        wait.until(ExpectedConditions.visibilityOf(numberInstances));
        new Actions(driver).scrollToElement(numberInstances).perform();
        numberInstances.sendKeys(Keys.DELETE);
        numberInstances.sendKeys(String.valueOf(instances));
    }

    /**
     * Selects the operating system option.
     */
    public void selectOperatingSystem() {
        operatingSystem.click();
        operatingSystemOption.click();
    }

    /**
     * Selects the machine family option from the dropdown
     */
    public void selectMachineFamily() {
        wait.until(ExpectedConditions.elementToBeClickable(machineFamily)).click();
        selectMachineFamily.click();
    }

    /**
     * Selects the series option from dropdown
     */
    public void selectSeries() {
        wait.until(ExpectedConditions.visibilityOf(openSeries)).click();
        selectSeries.click();
    }

    /**
     * Selects machine type from the dropdown
     */
    public void selectMachineType() {
        wait.until(ExpectedConditions.visibilityOf(machineType)).click();
        selectMachineType.click();
    }

    /**
     * Adds GPUs to the configutation
     */
    public void addGpu() {
        wait.until(ExpectedConditions.elementToBeClickable(gpuButton)).click();
    }

    /**
     * Waits for the list of GPU elements to load
     */
    public void waitForElementsToLoad() {
        do {
            listOfGPU = driver.findElements(By.cssSelector("div.VfPpkd-aPP78e"));
        } while (listOfGPU.size() != 13);
    }

    /**
     * Selects the GPU model from dropdown
     */
    public void selectGPUModel() {
        WebElement GPUType = listOfGPU.get(7);
        wait.until(ExpectedConditions.elementToBeClickable(GPUType)).click();
        selectGpuType.click();
    }

    /**
     * Selects number of GPUs from dropdown
     */
    public void selectNumberOfGPU() {
        WebElement GPUNumber = listNumberOfGPU.get(8);
        wait.until(ExpectedConditions.elementToBeClickable(GPUNumber)).click();
        wait.until(ExpectedConditions.visibilityOf(selectNumberOfGpu)).click();
    }

    /**
     * Selects the local SSD option
     */
    public void setLocalSSD() {
        wait.until(ExpectedConditions.visibilityOf(localSSD)).click();
        wait.until(ExpectedConditions.visibilityOf(selectLocalSSD)).click();
    }

    /**
     * Selects the region option from dropdown
     */
    public void selectRegion() {
        wait.until(ExpectedConditions.elementToBeClickable(region)).click();
        wait.until(ExpectedConditions.visibilityOf(selectRegion)).click();
    }

    /**
     * Sets the commited use
     */
    public void setCommitedUse() {
        wait.until(ExpectedConditions.elementToBeClickable(commitedUse)).click();
    }

    /**
     * Shares the configuration
     */
    public void setShare() {
        wait.until(ExpectedConditions.invisibilityOf(updateMessage));
        wait.until(ExpectedConditions.visibilityOf(share)).click();
    }
}



