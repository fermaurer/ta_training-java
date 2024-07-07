package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page class representing the Pastebin opening page functionality.
 * Extends {@link BasePage} to inherit WebDriver initialization.
 */
public class PastebinOpeningPage extends BasePage {

    @FindBy(id = "postform-text")
    private WebElement textCode;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingDropdown;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement pasteNameTitle;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement submitButton;


    private WebDriverWait wait;

    /**
     * Constructor to initialize the Pastebin opening page
     * with WebDriver and set up WebDriverWait.
     * @param driver Instance of WebDriver to be used for interacting with the page.
     */
    public PastebinOpeningPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Opens the Pastebin website by navigating to its URL.
     */
    public void open() {
        driver.get("https://pastebin.com");
    }

    /**
     * Enters the given code into the code input field.
     * @param codeInput Code to be entered into the input field.
     */
    public void enterCode(String codeInput) {
        textCode.sendKeys(codeInput);
    }

    /**
     * Select the code´s style.
     * @param highlightStyle Code style option to be selected.
     */
    public void selectSyntaxHighlighting(String highlightStyle) {
        syntaxHighlightingDropdown.click();
        WebElement syntaxOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='"+ highlightStyle +"']")));
        syntaxOption.click();
    }

    /**
     * Sets the expiration time for the paste.
     * @param optionTime The expiration option to be selected.
     */
    public void setPasteExpirationTime(String optionTime) {
        pasteExpiration.click();
        selectExpirationOption(optionTime);
    }

    /**
     * Selects the specified expiration option from the dropdown menu.
     * @param optionTime The expiration option to be selected from the dropdown.
     */
    private void selectExpirationOption(String optionTime) {
        WebElement expirationOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@id='select2-postform-expiration-results']/li[text()='" + optionTime + "']")));
        expirationOption.click();
    }

    /**
     * Enters the name/title for the paste on Pastebin.
     * @param name Name/title to be entered for the paste.
     */
    public void pasteNameInput(String name) {
        pasteNameTitle.sendKeys(name);

    }

    /**
     * Creates a new paste on Pastebin with the provided code, expiration time, and name/title.
     * @param codeInput Code to be entered on the input field.
     * @param optionTime The expiration option to be selected.
     * @param name The name/title to be entered.
     */
    public void createNewPaste(String codeInput, String highlightStyle, String optionTime, String name) {
        enterCode(codeInput);
        selectSyntaxHighlighting(highlightStyle);
        setPasteExpirationTime(optionTime);
        pasteNameInput(name);
    }

    /**
     * Clicks the submit button to create the new paste.
     */
    public void clickSubmitButton() {
        submitButton.click();
    }



}




