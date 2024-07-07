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

    private PastebinResultPage newPastePage;

    private PastebinResultPage highlightingStyle;

    private PastebinResultPage inputText;

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
     * Enters code, highlight style, sets expiration time, and enters name for the paste.
     * Submits the paste creation form.
     */
    public void doPage(){
        openPage = new PastebinOpeningPage(driver);

        String codeInput = """
                git config --global user.name  "New Sheriff in Town
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force
                """;
        String highlightStyle = "Bash";
        String optionTime = "10 Minutes";
        String name = "how to gain dominance among developers";

        openPage.open();
        openPage.createNewPaste(codeInput, highlightStyle, optionTime, name);
        openPage.clickSubmitButton();
    }

    /**
     * Test to verify the successful creation of a new paste
     * Calls {@link# doPage()} to create a new paste.
     * Gets the success message of the created paste.
     * Asserts that the actual success message matches the expected success message.
     */
   @Test
    public void checkPasteTitle() {
        doPage();

        newPastePage = new PastebinResultPage(driver);

        String actualTitle = newPastePage.getPasteTitle();
        String expectedTitle = "how to gain dominance among developers";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    /**
     * Test to verify the selection of highlight style.
     * Calls {@link #doPage()} to create a new paste.
     * Gets the button text
     * Asserts that the actual text matches the expected test.
     */
    @Test
    public void checkHighlighting() {
        doPage();

        highlightingStyle= new PastebinResultPage(driver);

        String actualHighlight = highlightingStyle.getHighlighting();
        String expectedHighlight = "Bash";

        Assert.assertEquals(expectedHighlight, actualHighlight);
    }

    /**
     * Test to verify the input text
     * Calls {@link #doPage} to create a new paste.
     * Gets the input text.
     * Asserts that the actual text matches the expected test.
     */
    @Test
    public void checkInputText() {
        doPage();

        inputText= new PastebinResultPage(driver);

        String actualHighlight = inputText.getCodeText();
        String expectedHighlight = "$(git commit-tree HEAD^{tree} -m \"Legacy code\")";

        Assert.assertEquals(expectedHighlight, actualHighlight);
    }

    /**
     * Closes the webpage.
     */
   @After
    public void tearDown() throws InterruptedException {
        //this Thread.sleep is added so the reviewer can see if the values are filled correctly before closing the driver
        Thread.sleep(3000);
        if (this.driver != null) {
            this.driver.quit();
        }

    }

}
