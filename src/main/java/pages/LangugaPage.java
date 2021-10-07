package pages;

import helpers.SeleniumHelpers;
import locators.LanguageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LangugaPage {

    WebDriver driver;
    WebDriverWait wait;
    LanguageLocators locators;
    Actions actions;

    public LangugaPage(WebDriver driver, int timeOut) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        locators = new LanguageLocators();
        PageFactory.initElements(driver, locators);
        actions = new Actions(driver);
    }

    public void changeLanguage(String lang) {
        locators.getLanguageFlag().click();
        System.out.println(lang);
        switch (lang) {
            case "en":
                SeleniumHelpers.clickOnElement(locators.getEnglishFlag(), wait);
                break;
            case "de":
                SeleniumHelpers.clickOnElement(locators.getDeutschFlag(), wait);
                break;
            default:
                System.out.println("Wrong language");
                break;
        }

        //Case: pointable language list instead clickable button
        //actions.moveToElement(locators.getEnglishFlag()).build().perform(); //point button instead click
        //next: wait until visibilityOf(languageList) and wain until elementToBeClickable(languageList)
        //next: click element form list locators.languageFromList.get(0).click() /*li elements*/
    }

    public String getNavigationSearch() {
        return locators.getNavElementsToAssert().get(0).getText();
    }

    public String getNavigationSell() {
        return locators.getNavElementsToAssert().get(1).getText();
    }

    public String getNavigationInform() {
        return locators.getNavElementsToAssert().get(2).getText();
    }
}
