package com.epam.tests;

import com.epam.Pages.*;
import com.epam.Utils.TestUtil;
import com.epam.driver.DriverSingleton;
import com.epam.enums.*;
import com.epam.model.ComputeEngine;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

/**
 * Test class for automated testing of Google calculator functionality.
 */
public class TestFile {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private SummaryPage summaryPage;
    String lastHandle = "";
    public static ComputeEngine testData;

    /**
     * Sets up the environment for automated tests.
     * Configures the path to the Chrome driver.
     * Maximizes the browser window before each test.

     */

        @BeforeClass(alwaysRun = true)
    public static void setUp() {
        System.setProperty("browser", "chrome");
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));

/////////////////////////////////////////////////////////////////////////////////////////
    //Initializes test data with predefined values.
            //Here you can change the instances to more than 50000, like use 60000 and the test
            //will fail and take a sreenshot and store it in the screenshots package
        testData = new ComputeEngine(4, OperativeSystems.DEBIAN,
                MachineFamily.GENERAL, Series.N1, MachineType.N1_STANDARD8,
                ProvisioningModel.REGULAR, true, GPUModel.NVIDIA_V100,
                NumberGPUs.GPU1, LocalSSD.TWO375, Region.NETHERLANDS, CommitedUse.ONE_YEAR);
    }

    /**
     * Calls executeCommonFlow method
     */
    @BeforeMethod(alwaysRun = true)
    public void commonSetUp() {
        executeCommonFlow();
    }


    /**
     * Executes all steps neccesary to fill out the Google Cloud Calculator form,
     * create a summary
     */

    public void executeCommonFlow() {
        //Navigate to Google Cloud home page and search for the pricing calculator.
        GoogleCloudHomePage homePage = new GoogleCloudHomePage(driver);
        homePage.open();
        homePage.inputSearch();

        //Click on Google Cloud Plattform link and navigate to the welcome page
        GoogleCloudPlattform plattform = new GoogleCloudPlattform(driver);
        plattform.clickCloudPlattform();

        //Click add to estimate and select Compute Engine
        GoogleCloudWelcome welcome = new GoogleCloudWelcome(driver);

        //Press the addToEstimate button
        welcome.addToEstimate();

        //Selects Compute Engine option
        welcome.selectComputeEngine();

        //Fill out compute engine form details
        ComputeEnginePage computeEngine = new ComputeEnginePage(driver);

        //Closes chat section
        computeEngine.closeChat();

        //If you change the number of instances the test will fail and a Screenshot will be
        //taken and stored in src/test/java/epam/screenshots/
        //Sets the number of instances
        computeEngine.setNumberOfInstances(testData);

        //Selects the operating system
        computeEngine.selectOperatingSystem(testData);

        //Selects MachineFamily
        computeEngine.selectMachineFamily(testData);

        //Selects series
        computeEngine.selectSeries(testData);

        //Selects machine type
        computeEngine.selectMachineType(testData);

        //Selects to add GPUs
        computeEngine.addGpu(testData);

        //Helps to wait for the elements on the page to be completely loaded
        computeEngine.waitForElementsToLoad();

        //Selects GPU model
        computeEngine.selectGPUModel(testData);

        //Selects number of GPUs
        computeEngine.selectNumberOfGPU(testData);

        //Selects Local SSD
        computeEngine.setLocalSSD(testData);

        //Selects region
        computeEngine.selectRegion(testData);

        //Clicks on Commited use button
        computeEngine.setCommitedUse(testData);

        //Clicks on share button
        computeEngine.setShare();

        //Open and switch to summary page
        OpenSummaryPage openSummaryPage = new OpenSummaryPage(driver);
        openSummaryPage.openSummary();

        //Turns to the next page
        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            lastHandle = handle;
        }
        driver.switchTo().window(lastHandle);

        summaryPage = new SummaryPage(driver);
    }

    /**
     * Verifies the number of instances in the summary page.
     */
    @Test(groups = "all")
    public void instancesTest() {
        String actualInstances = summaryPage.getNumberOfInstances();
        Assert.assertEquals(actualInstances, String.valueOf(testData.getInstances()));
    }

    /**
     * Verifies the operating system in the summary page.
     */
    @Test(groups = {"smoke", "all"})
    public void operatingSystemTest() {
        String actualOperatingSystem = summaryPage.getOperatingSystem();
        Assert.assertEquals(actualOperatingSystem, testData.getOperativeSystem().getOsName());
    }

    /**
     * Verifies the provisioning model in the summary page.
     */
    @Test(groups = "all")
    public void provisioningModelTest() {
        String actualProvisioningModel = summaryPage.getProvisioningModel();
        Assert.assertEquals(actualProvisioningModel, testData.getProvisioningModel().getPmName());
    }

    /**
     * Verifies the machine type in the summary page.
     */
    @Test(groups = "all")
    public void machineTypeTest() {
        String actualMachineType = summaryPage.getMachineTypeText();
        Assert.assertEquals(actualMachineType, testData.getMachineType().getMtName());
    }

    /**
     * Verifies the GPUs added in the summary page.
     */
    @Test(groups = "all")
    public void addGPUsTest() {
        String actualAddGPUs = summaryPage.getAddGPUsText();
        Assert.assertEquals(actualAddGPUs, String.valueOf(testData.getAddGPUs()));
    }

    /**
     * Verifies the Local SSD in the summary page.
     */
    @Test(groups = "all")
    public void localSSDTest() {
        String actualLocalSSD = summaryPage.getLocalSSDText();
        Assert.assertEquals(actualLocalSSD, testData.getLocalSSD().getSDDName());
    }

    /**
     * Verifies the data center location in the summary page.
     */
    @Test(groups = "all")
    public void dataCenterLocationTest() {
        String actualDataCenterLocation = summaryPage.getDataCenterLocationText();
        Assert.assertEquals(actualDataCenterLocation, testData.getRegion().getRegionName());
    }

    /**
     * Verifies the committed use in the summary page.
     */
    @Test(groups = "all")
    public void commitedUseTest() {
        String actualCommitedUse = summaryPage.getCommitedUseText();
        Assert.assertEquals(actualCommitedUse, testData.getCommitedUse().getCuName());
    }

    /**
     * Takes a screenshot if the test fails and stores it in the screenshot package
     */
    @AfterMethod(alwaysRun = true)
    public static void takeScreenShotIfFail(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = result.getName() + "_" + timestamp + ".png";
            File destFile = new File("src/test/java/com/epam/screenshots/" + screenshotName);
            try {
                FileUtils.copyFile(screenshot, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Closes the webpage.
     */
    @AfterClass(alwaysRun = true)
    public static void teardown(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
