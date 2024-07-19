package com.epam.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents the summary page of Google Cloud Calculator.
 * Extends {@link BasePage} that initializes WebDriver and the WebElements
 */
public class SummaryPage extends BasePage{

    @FindBy(xpath = "//span[text()='Number of Instances']/following-sibling::span")
    private WebElement instancesNumberLabel;

    @FindBy(xpath = "//span[text()='Operating System / Software']/following-sibling::span")
    private WebElement operatingSystemLabel;

    @FindBy(xpath = "//span[text()='Provisioning Model']/following-sibling::span")
    private WebElement provisioningModelLabel;

    @FindBy(xpath = "//span[text()='Machine type']/following-sibling::span")
    private WebElement machineTypeLabel;

    @FindBy(xpath = "//span[text()='Add GPUs']/following-sibling::span")
    private WebElement addGPUsLabel;

    @FindBy(xpath = "//span[text()='Local SSD']/following-sibling::span")
    private WebElement localSSDLabel;

    @FindBy(xpath = "//span[text()='Region']/following-sibling::span")
    private WebElement dataCenterLocationLabel;

    @FindBy(xpath = "//span[text()='Committed use discount options']/following-sibling::span")
    private WebElement commitedUseLabel;

    /**
     * Constructor to initialize SummmaryPage with the WebDriver.
     * @param driver WebDriver instance to be used for interacting with the web elements.
     */
    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Retrieves a WebElement of some element on the page, to give the page time to be
     * fully loaded
     * @return WebElement representing a specific element on the summary page.
     */
    public WebElement getSomeElement(){
        wait.until(ExpectedConditions.visibilityOf(instancesNumberLabel));
        return instancesNumberLabel;
    }

    /**
     * Retrives the number of instances selected on the summary page.
     * @return WebElement representing the number of instances
     */
    public String getNumberOfInstances() {
        String numberOfInstances = instancesNumberLabel.getText();
        return numberOfInstances;
    }

    /**
     * Retrives the operating system selected in the summary.
     * @return String representing the selected operating system
     */
    public String getOperatingSystem() {
        String operatingSystem = operatingSystemLabel.getText();
        return operatingSystem;
    }

    /**
     * Retrieves the provisioning model selected in the summary
     * @return String respresenting the selected provisioning model
     */
    public String getProvisioningModel() {
        String provisioningModel = provisioningModelLabel.getText();
        return provisioningModel;
    }

    /**
     * Retrieves the machine type selected in the summary
     * @return String representing the selected machine type
     */
    public String getMachineTypeText() {
        String machineType = machineTypeLabel.getText();
        return machineType;
    }

    /**
     * Retrieves wheter the GPUs have been added in the summary.
     * @return String indicating GPUs have been added
     */
    public String getAddGPUsText() {
        String addGPUs = addGPUsLabel.getText();
        return addGPUs;
    }

    /**
     * Retrieves the local SSD selected in the summary
     * @return String representing the selected local SSD
     */
    public String getLocalSSDText() {
        String localSSD = localSSDLabel.getText();
        return localSSD;
    }

    /**
     * Retrieves the data center location selected in the summary
     * @return String representing the selected data center location
     */
    public String getDataCenterLocationText() {
        String dataCenterLocation = dataCenterLocationLabel.getText();
        return dataCenterLocation;
    }

    /**
     * Retrieves the selected commited use selected in the summary
     * @return String representing the selected committed use
     */
    public String getCommitedUseText() {
        String commitedUse = commitedUseLabel.getText();
        return commitedUse;
    }
}
