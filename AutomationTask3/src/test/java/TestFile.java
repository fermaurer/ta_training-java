import com.epam.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * Test class for automated testing of Google calculator functionality.
 */
public class TestFile {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private SummaryPage summaryPage;

    /**
     * Sets up the environment for automated tests.
     * Configures the path to the Chrome driver.
     * Maximizes the browser window before each test.
     * Executes all the steps, filling all the fields and choosing all the target options.
     * Submits the form so Google calculator creates a summary that will be used to make all the tests.
     */

    @BeforeClass
    public static void setUp() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /**
     * Executes all steps neccesary to fill out the Google Cloud Calculator form,
     * create a summary and perform validations on the summary page.
     */
    @Test
    public void testAllConfigurations(){
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
        int instancesToAdd = 4;
        computeEngine.setNumberOfInstances(instancesToAdd);
        computeEngine.selectOperatingSystem();
        computeEngine.selectMachineFamily();
        computeEngine.selectSeries();
        computeEngine.selectMachineType();
        computeEngine.addGpu();
        computeEngine.waitForElementsToLoad();
        computeEngine.selectGPUModel();
        computeEngine.selectNumberOfGPU();
        computeEngine.setLocalSSD();
        computeEngine.selectRegion();
        computeEngine.setCommitedUse();
        computeEngine.setShare();

        //Open and switch to summary page
        OpenSummaryPage openSummaryPage = new OpenSummaryPage(driver);
        openSummaryPage.openSummary();

        Set<String> handles = driver.getWindowHandles();
        String lastHandle = "";

        for (String handle : handles) {
            lastHandle = handle;
        }
        driver.switchTo().window(lastHandle);

        //Wait until the summary page is fully loaded
        summaryPage = new SummaryPage(driver);
        wait.until(ExpectedConditions.visibilityOf(summaryPage.getSomeElement()));

        // Asserts for all configurations
        String actualInstances = summaryPage.getNumberOfInstances();
        String expectedInstances = "4";
        Assert.assertEquals(expectedInstances, actualInstances);

        String actualOperatingSystem = summaryPage.getOperatingSystem();
        String expectedOperatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
        Assert.assertEquals(expectedOperatingSystem, actualOperatingSystem);

        String actualProvisioningModel = summaryPage.getProvisioningModel();
        String expectedProvisioningModel = "Regular";
        Assert.assertEquals(expectedProvisioningModel, actualProvisioningModel);

        String actualMachineType = summaryPage.getMachineTypeText();
        String expectedMachineType = "n1-standard-8, vCPUs: 8, RAM: 30 GB";
        Assert.assertEquals(expectedMachineType, actualMachineType);

        String actualAddGPUs = summaryPage.getAddGPUsText();
        String expectedGPUsText = "true";
        Assert.assertEquals(expectedGPUsText, actualAddGPUs);

        String actualLocalSSD = summaryPage.getLocalSSDText();
        String expectedLocalSSD = "2x375 GB";
        Assert.assertEquals(expectedLocalSSD, actualLocalSSD);

        String actualDataCenterLocation = summaryPage.getDataCenterLocationText();
        String expectedDataCenterLocation = "Netherlands (europe-west4)";
        Assert.assertEquals(expectedDataCenterLocation, actualDataCenterLocation);

        String actualCommitedUse = summaryPage.getCommitedUseText();
        String expectedCommitedUse = "1 year";
        Assert.assertEquals(expectedCommitedUse, actualCommitedUse);
    }

    /**
     * Closes the webpage.
     */
    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
