import com.epam.*;
import com.epam.PastebinOpeningPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestFile {

    private WebDriver driver;
    private PastebinOpeningPage openPage;
    private PasteCreatedPage pasteCreationPage;

    @Before
    public void setUp() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectPath + "/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();


        openPage = new PastebinOpeningPage(driver);

        String codeInput = "Hello from WebDriver";
        String optionTime = "10 Minutes";
        String name = "helloweb";

        openPage.open();
        openPage.createNewPaste(codeInput, optionTime, name);
        openPage.clickSubmitButton();

    }


    @Test
    public void checkNewPasteTest() {

        pasteCreationPage = new PasteCreatedPage(driver);

        String actualSuccessMessage = pasteCreationPage.getSuccessMessage();
        String expectedSuccessMessage = "NOTE: Your guest paste has been posted. If you sign up for a free account, you can edit and delete your pastes!";

        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }


    @After
    public void tearDown() throws InterruptedException {
        //this Thread.sleep is added so the reviewer can see if the values are filled correctly before closing the driver
        Thread.sleep(10000);
        if (this.driver != null) {
            this.driver.quit();
        }

    }
}


