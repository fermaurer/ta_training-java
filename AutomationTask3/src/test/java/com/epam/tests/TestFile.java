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
     * Executes all the steps, filling all the fields and choosing all the target options.
     * Submits the form so Google calculator creates a summary that will be used to make all the tests.
     */

        @BeforeClass(alwaysRun = true)
    public static void setUp() {
        System.setProperty("browser", "chrome");
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        testData = new ComputeEngine(4, OperativeSystems.DEBIAN,
                MachineFamily.GENERAL, Series.N1, MachineType.N1_STANDARD8, ProvisioningModel.REGULAR, true,
                GPUModel.NVIDIA_V100, NumberGPUs.GPU1, LocalSSD.TWO375, Region.NETHERLANDS, CommitedUse.ONE_YEAR);
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
        welcome.addToEstimate();
        welcome.selectComputeEngine();

        //Fill out compute engine form details
        ComputeEnginePage computeEngine = new ComputeEnginePage(driver);
        //If you change the number of instances the test will fail and a Screenshot will be
        //taken and stored in src/test/java/epam/screenshots/
        computeEngine.closeChat();
        computeEngine.setNumberOfInstances(testData);
        computeEngine.selectOperatingSystem(testData);
        computeEngine.selectMachineFamily(testData);
        computeEngine.selectSeries(testData);
        computeEngine.selectMachineType(testData);
        computeEngine.addGpu(testData);
        computeEngine.waitForElementsToLoad();
        computeEngine.selectGPUModel(testData);
        computeEngine.selectNumberOfGPU(testData);
        computeEngine.setLocalSSD(testData);
        computeEngine.selectRegion(testData);
        computeEngine.setCommitedUse(testData);
        computeEngine.setShare();

        //Open and switch to summary page
        OpenSummaryPage openSummaryPage = new OpenSummaryPage(driver);
        openSummaryPage.openSummary();

        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            lastHandle = handle;
        }
        driver.switchTo().window(lastHandle);

        summaryPage = new SummaryPage(driver);
    }

    @Test(groups = "all")
    public void instancesTest() {
        String actualInstances = summaryPage.getNumberOfInstances();
        Assert.assertEquals(actualInstances, String.valueOf(testData.getInstances()));
    }

    @Test(groups = {"smoke", "all"})
    public void operatingSystemTest() {
        String actualOperatingSystem = summaryPage.getOperatingSystem();
        Assert.assertEquals(actualOperatingSystem, testData.getOperativeSystem().getOsName());
    }

    @Test(groups = "all")
    public void provisioningModelTest() {
        String actualProvisioningModel = summaryPage.getProvisioningModel();
        String expectedProvisioningModel = "Regular";
        Assert.assertEquals(actualProvisioningModel, testData.getProvisioningModel().getPmName());
    }

    @Test(groups = "all")
    public void machineTypeTest() {
        String actualMachineType = summaryPage.getMachineTypeText();
        Assert.assertEquals(actualMachineType, testData.getMachineType().getMtName());
    }

    @Test(groups = "all")
    public void addGPUsTest() {
        String actualAddGPUs = summaryPage.getAddGPUsText();
        Assert.assertEquals(actualAddGPUs, String.valueOf(testData.getAddGPUs()));
    }

    @Test(groups = "all")
    public void localSSDTest() {
        String actualLocalSSD = summaryPage.getLocalSSDText();
        Assert.assertEquals(actualLocalSSD, testData.getLocalSSD().getSDDName());
    }

    @Test(groups = "all")
    public void dataCenterLocationTest() {
        String actualDataCenterLocation = summaryPage.getDataCenterLocationText();
        String expectedDataCenterLocation = "Netherlands (europe-west4)";
        Assert.assertEquals(actualDataCenterLocation, testData.getRegion().getRegionName());
    }

    @Test(groups = "all")
    public void commitedUseTest() {
        String actualCommitedUse = summaryPage.getCommitedUseText();
        String expectedCommitedUse = "1 year";
        Assert.assertEquals(actualCommitedUse, testData.getCommitedUse().getCuName());
    }

    /**
     * Closes the webpage.
     */
    @AfterMethod(alwaysRun = true)
    public static void takeScreenShotIfFail(ITestResult result) {
        // Tomar captura de pantalla si el test falla
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

    @AfterClass(alwaysRun = true)
    public static void teardown(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
