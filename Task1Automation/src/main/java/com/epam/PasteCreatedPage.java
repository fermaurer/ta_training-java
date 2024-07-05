package com.epam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasteCreatedPage extends BasePage{

    @FindBy(xpath = "//*[contains(@class,'notice -success -post-view')]")
    private WebElement successMessage;

    public PasteCreatedPage(WebDriver driver) {
        super(driver);
    }


    public String getSuccessMessage() {
        String messageText = successMessage.getText();
        System.out.println(messageText);
        return messageText;
    }
}
