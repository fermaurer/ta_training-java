package com.epam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinResultPage extends BasePage{

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement newPasteTitle;

    @FindBy(linkText = "Bash")
    private WebElement highlighting;

    @FindBy(xpath = "//span[@class='es4']")
    private WebElement inputCodeText;

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    public String getPasteTitle() {
        String pasteTitle = newPasteTitle.getText();
        return pasteTitle;
    }

    public String getHighlighting() {
        String highlightStyle = highlighting.getText();
        return highlightStyle;
    }

    public String getCodeText() {
        String CodingText = inputCodeText.getText();
        return CodingText;
    }
}
