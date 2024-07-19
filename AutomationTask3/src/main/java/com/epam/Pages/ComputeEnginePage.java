package com.epam.Pages;

import com.epam.model.ComputeEngine;
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

    @FindBy(xpath = "//span[@id='c28']/following-sibling::div")
    private WebElement machineFamily;

    @FindBy(xpath = "//span[@id='c32']/following-sibling::div")
    private WebElement openSeries;

    @FindBy(xpath = "//span[@id='c36']/following-sibling::div")
    private WebElement machineType;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement gpuButton;

    @FindBy(css = "div.VfPpkd-aPP78e")
    private List<WebElement> listOfGPU;

    @FindBy(css = "div.VfPpkd-aPP78e")
    private List<WebElement> listNumberOfGPU;

    @FindBy(xpath = "//span[@id='c44']/following-sibling::div")
    private WebElement localSSD;

    @FindBy(xpath = "//span[@id='c48']/following-sibling::div")
    private WebElement region;

    @FindBy(xpath = "//span[@class='FOBRw-vQzf8d']")
    private WebElement share;

    @FindBy(xpath = "//div[contains(@class,'Z7Qi9d') and contains(@class, ' HY0Uh')]")
    private WebElement updateMessage;

    @FindBy(xpath = "//span[@class='close']")
    private WebElement chatCloseButton;

    /**
     * Constructor to initialize ComputeEnginePage with the WebDriver.
     *
     * @param driver WebDriver instance to be used for interacting with the web elements.
     */
    public ComputeEnginePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Closes the chat
     */
    public void closeChat() {
        wait.until(ExpectedConditions.visibilityOf(chatCloseButton));
        chatCloseButton.click();
    }

    /**
     * Sets the number of instances
     */

    public void setNumberOfInstances(ComputeEngine testData) {
        wait.until(ExpectedConditions.visibilityOf(numberInstances));
        new Actions(driver).scrollToElement(numberInstances).perform();
        numberInstances.sendKeys(Keys.DELETE);
        numberInstances.sendKeys(String.valueOf(testData.getInstances()));
    }

    /**
     * Selects the operating system option.
     */
    public void selectOperatingSystem(ComputeEngine testData) {
        operatingSystem.click();
        driver.findElement(By.xpath("//li[@data-value='" + testData.getOperativeSystem().getOsLocator() + "']"));
    }

    /**
     * Selects the machine family option from the dropdown
     */
    public void selectMachineFamily(ComputeEngine testData) {
        wait.until(ExpectedConditions.elementToBeClickable(machineFamily)).click();
        driver.findElement(By.xpath("//li[@data-value='" + testData.getMachineFamily().getMfLocator() + "']")).click();
    }

    /**
     * Selects the series option from dropdown
     */
    public void selectSeries(ComputeEngine testData) {
        wait.until(ExpectedConditions.visibilityOf(openSeries)).click();
        driver.findElement(By.xpath("//li[@data-value='" + testData.getSeries().getsLocator() + "']")).click();
    }

    /**
     * Selects machine type from the dropdown
     */
    public void selectMachineType(ComputeEngine testData) {
        wait.until(ExpectedConditions.visibilityOf(machineType)).click();
        driver.findElement(By.xpath("//li[@data-value='" + testData.getMachineType().getMtLocator() + "']")).click();
    }

    /**
     * Adds GPUs to the configutation
     */
    public void addGpu(ComputeEngine testData) {
        if (testData.getAddGPUs() == true) {
            wait.until(ExpectedConditions.elementToBeClickable(gpuButton)).click();
        }
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
    public void selectGPUModel(ComputeEngine testData) {
        WebElement GPUType = listOfGPU.get(7);
        wait.until(ExpectedConditions.elementToBeClickable(GPUType)).click();
        wait.until((ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//li[@data-value='"+testData.getGpuModel().getGpuLocator()+"']"))))).click();
    }

    /**
     * Selects number of GPUs from dropdown
     */
    public void selectNumberOfGPU(ComputeEngine testData) {
        WebElement GPUNumber = listNumberOfGPU.get(8);
        wait.until(ExpectedConditions.elementToBeClickable(GPUNumber)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@data-value='"+ testData.getNumberGPUs().getGpusLocator()+"']")))).click();
    }

    /**
     * Selects the local SSD option
     */
    public void setLocalSSD(ComputeEngine testData) {
        wait.until(ExpectedConditions.visibilityOf(localSSD)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@aria-label='Local SSD']/li[" + testData.getLocalSSD().getSDDLocator() + "]")))).click();
    }

    /**
     * Selects the region option from dropdown
     */
    public void selectRegion(ComputeEngine testData) {
        wait.until(ExpectedConditions.elementToBeClickable(region)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@data-value='"+ testData.getRegion().getRegionLocator() +"']")))).click();
    }

    /**
     * Sets the commited use
     */
    public void setCommitedUse(ComputeEngine testData) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement
                (By.xpath("//label[@for='"+ testData.getCommitedUse().getCuLocator()+"']")))).click();
    }

    /**
     * Shares the configuration
     */
    public void setShare() {
        wait.until(ExpectedConditions.invisibilityOf(updateMessage));
        wait.until(ExpectedConditions.visibilityOf(share)).click();
    }
}



