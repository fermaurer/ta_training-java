package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PastebinOpeningPage extends BasePage {

    @FindBy(id = "postform-text")
    private WebElement textCode;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement pasteNameTitle;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement submitButton;


    private WebDriverWait wait;

    public PastebinOpeningPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://pastebin.com");
    }

    public void enterCode(String codeInput) {
        textCode.sendKeys(codeInput);
    }

    public void setPasteExpirationTime(String optionTime) {
        pasteExpiration.click();
        selectExpirationOption(optionTime);
    }

    private void selectExpirationOption(String optionTime) {
        WebElement expirationOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@id='select2-postform-expiration-results']/li[text()='" + optionTime + "']")));
        expirationOption.click();
    }

    public void pasteNameInput(String name) {
        pasteNameTitle.sendKeys(name);
    }

    public void createNewPaste(String codeInput, String optionTime, String name) {
        enterCode(codeInput);
        setPasteExpirationTime(optionTime);
        pasteNameInput(name);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }
}





