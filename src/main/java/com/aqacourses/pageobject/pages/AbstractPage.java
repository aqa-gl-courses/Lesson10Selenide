package com.aqacourses.pageobject.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.aqacourses.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPage {

    protected BaseTest testClass;

    //
    // Web elements with @FindBy annotation
    //
    @FindBy(xpath = "//ul[@id='main-nav']//span[.='PYTHON']/..")
    private WebElement pythonLink;

    @FindBy(xpath = "//div[@id='main']")
    protected WebElement pageDiv;

    /** Constructor */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        page(this);
        testClass.waitTillElementIsVisible(pageDiv);
    }

    /**
     * Click on Python link and get instance of page
     *
     * @return PythonPage
     */
    public PythonPage clickPythonLink() {
        testClass.waitTillElementIsVisible(pythonLink);
        $(pythonLink).click();
        return new PythonPage(testClass);
    }
}
