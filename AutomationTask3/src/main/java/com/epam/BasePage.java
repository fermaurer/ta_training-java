package com.epam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Base class for Page Objects in Selenium WebDriver framework.
 * Provides initialization of WebDriver instance and PageFactory elements.
 */
public class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;

    /**
     * Constructor to initialize WebDriver instance and initialize PageFactory elements
     * @param driver Instance of WebDriver to be used by the page.
     */
    public BasePage(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

}
