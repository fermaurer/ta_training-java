import com.epam.*;
import com.epam.PastebinOpeningPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestFile {

    private WebDriver driver;
    private PastebinOpeningPage openPage;

    private PastebinResultPage newPastePage;

    private PastebinResultPage highlightingStyle;

    private PastebinResultPage inputText;

    @Before
    public void setUp() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

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


   @Test
    public void checkPasteTitle() {
        newPastePage = new PastebinResultPage(driver);

        String actualTitle = newPastePage.getPasteTitle();
        String expectedTitle = "how to gain dominance among developers";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void checkHighlighting() {
        highlightingStyle= new PastebinResultPage(driver);

        String actualHighlight = highlightingStyle.getHighlighting();
        String expectedHighlight = "Bash";

        Assert.assertEquals(expectedHighlight, actualHighlight);
    }

    @Test
    public void checkInputText() {
        inputText= new PastebinResultPage(driver);

        String actualHighlight = inputText.getCodeText();
        String expectedHighlight = "$(git commit-tree HEAD^{tree} -m \"Legacy code\")";

        Assert.assertEquals(expectedHighlight, actualHighlight);
    }


   @After
    public void tearDown() throws InterruptedException {
        //this Thread.sleep is added so the reviewer can see if the values are filled correctly before closing the driver
        Thread.sleep(3000);
        if (this.driver != null) {
            this.driver.quit();
        }

    }

}
