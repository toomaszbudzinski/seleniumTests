package helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class SeleniumHelpers {
    public static void selectByTextFromDropDown(WebElement webElement, String expectedText) {
        new Select(webElement).selectByVisibleText(expectedText);
    }

    public static void selectByTextFromDropDown(WebElement webElement, String expectedText, Wait wait) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        new Select(webElement).selectByVisibleText(expectedText);
    }

    public static void selectByTextFromElementList(List<WebElement> listOfWebElelement, String expectedText) {
        for (WebElement element : listOfWebElelement) {
            if (element.getText().contains(expectedText)) {
                element.click();
                break;
            }
        }
    }

    public static void clickOnElement(WebElement webElement, Wait wait) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    public static void sendTextToElementAndLooseFocus(WebElement webElement, String expectedText) {
        webElement.sendKeys(expectedText);
        webElement.sendKeys(Keys.TAB);
        webElement.sendKeys(Keys.ENTER);
    }
}
