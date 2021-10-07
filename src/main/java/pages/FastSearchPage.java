package pages;

import helpers.SeleniumHelpers;
import locators.FastSearchLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastSearchPage {
    WebDriver driver;
    WebDriverWait wait;
    FastSearchLocators locators;

    public FastSearchPage(WebDriver driver, int timeOut) {
        this.driver = driver;
        locators = new FastSearchLocators();
        PageFactory.initElements(driver, locators);
        wait = new WebDriverWait(driver, timeOut);
    }

    public void selectMark(String mark) {
        //wait.until(ExpectedConditions.visibilityOf(locators.getMark()));
        //new Select(locators.getMark()).selectByVisibleText(mark);
        // OR
        SeleniumHelpers.selectByTextFromDropDown(locators.getMark(), mark, wait);
    }

    public void selectModel(String model) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getModel()));
        new Select(locators.getModel()).selectByVisibleText(model);
    }

    public void selectKilometer(String kilometer) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getKilometer()));
        //System.out.println(locators.getKilometer().getText());
        new Select(locators.getKilometer()).selectByValue(100000 + "");
    }

    public void selectCity(String city) {
        locators.getCity().sendKeys(city);
        locators.getCity().sendKeys(Keys.TAB);
    }

    public void search() {
        //locators.getSearchButton().click();
        SeleniumHelpers.clickOnElement(locators.getSearchButton(), wait);
    }
}
