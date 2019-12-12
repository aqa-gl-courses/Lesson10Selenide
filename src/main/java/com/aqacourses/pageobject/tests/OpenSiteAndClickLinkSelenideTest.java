package com.aqacourses.pageobject.tests;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

import com.aqacourses.pageobject.utils.YamlParser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenSiteAndClickLinkSelenideTest {

    @FindBy(xpath = "//ul[@id='main-nav']//span[.='PYTHON']/..")
    private WebElement pythonLink;

    @FindBy(xpath = "//ul[@id='main-nav']//span[.='HOME']/..")
    private WebElement homeLink;

    // Title constant
    private final String EXPECTED_TITLE = "Selenium Framework | Python Course";

    @Test
    public void testOpenSiteAndClickLinkSelenideTest() throws IOException {
        // Set that window should be maximized
        Configuration.startMaximized = true;

        // Open site
        open(YamlParser.getYamlData().getUrl());

        // Initialize elements
        page(this);

        // Wait till 'Python' link is visible
        $(pythonLink).shouldBe(Condition.visible);

        // CLick on 'Python' link
        $(pythonLink).click();

        // Verify title
        Assert.assertEquals("Titles are not the same", EXPECTED_TITLE, title());

        // Return to Home page
        $(byXpath("//ul[@id='main-nav']//span[.='HOME']/..")).shouldBe(Condition.visible).click();
    }
}
