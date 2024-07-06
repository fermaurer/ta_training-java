import com.epam.*;
import com.epam.PastebinOpeningPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test class for automated testing of Pastebin functionality.
 */
public class TestFile {

    private WebDriver driver;
    private PastebinOpeningPage openPage;
    private PasteCreatedPage pasteCreationPage;

    /**
     * Sets up the environment for automated tests.
     * Configures the path to the Chrome driver
     * Maximizes the browser window before each test.
     */
    @Before
    public void setUp() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Executes the steps to create a new paste
     * Opens the Pastebin opening page.
     * Enters code, sets expiration time, and enters name for the paste.
     * Submits the paste creation form.
     */
    public void doPaste() {
        openPage = new PastebinOpeningPage(driver);

        String codeInput = "Hello from WebDriver";
        String optionTime = "10 Minutes";
        String name = "helloweb";

        openPage.open();
        openPage.createNewPaste(codeInput, optionTime, name);
        openPage.clickSubmitButton();
    }

    /**
     * Test to verify the successful creation of a new paste
     * Calls {@link #doPaste()} to create a new paste.
     * Gets the success message of the created paste.
     * Asserts that the actual success message matches the expected success message.
     */
    @Test
    public void checkNewPasteTest() {

        doPaste();

        pasteCreationPage = new PasteCreatedPage(driver);

        String actualSuccessMessage = pasteCreationPage.getSuccessMessage();
        String expectedSuccessMessage = "NOTE: Your guest paste has been posted. If you sign up for a free account, you can edit and delete your pastes!";

        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }

    /**
     * Closes the webpage.
     */
    @After
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }

    }
}


