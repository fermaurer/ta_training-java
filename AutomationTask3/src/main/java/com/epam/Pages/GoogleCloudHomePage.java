package com.epam.Pages;

import com.epam.service.PropertyReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

/**
 * Represents Google Cloud Home Page and provides methods to interact with its elements
 * Extends the {@link BasePage} class that initializes the WebDriver and the WebElements
 */
public class GoogleCloudHomePage extends BasePage {

    @FindBy(xpath = "//input[@class = 'mb2a7b']")
    private WebElement searchbutton;

    /**
     * Constructor to initialize GoogleCloudHomePage with the WebDriver.
     * @param driver WebDriver instance to be used for interacting with the web elements.
     */
    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Opens Google Cloud Home page with property reader
     */
    public void open() {
        String url = PropertyReader.getProperty("url");
        driver.get(url);
    }

    /**
     * Inputs a search query in the search field and submits the search
     * This method clicks in the search button, types the query "Google
     * Cloud Plattform Pricing Calculator and presses Enter to submit the search.
     */
    public void inputSearch() {
        searchbutton.click();
        searchbutton.sendKeys("Google Cloud Platform Pricing Calculator");
        searchbutton.sendKeys(Keys.ENTER);
    }


}
