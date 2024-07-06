package com.epam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for Page Objects in Selenium WebDriver framework.
 * Provides initialization of WebDriver instance and PageFactory elements.
 */
public class BasePage {
    protected WebDriver driver;

    /**
     * Constructor to initialize WebDriver instance and initialize PageFactory elements
     * @param driver The instance of WebDriver to be used by the page.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
