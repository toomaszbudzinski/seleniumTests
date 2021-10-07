package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LanguageLocators {

    @FindBy(xpath = "//span[contains(@data-se,\"header-meta-action-toggle__language\")]/i")
    private WebElement languageFlag;

    @FindBy(xpath = "//li[contains(@class,\"header-meta-action-dropdown-item u-text-nowrap\")]/a[contains(text(),\"English\")]")
    private WebElement englishFlag;

    @FindBy(xpath = "//li[contains(@class,\"header-meta-action-dropdown-item u-text-nowrap\")]/a[contains(text(),\"Deutsch\")]")
    private WebElement deutschFlag;

    @FindBy(xpath = "//span[@class=\"header-nav-link header-nav-link-toggle mde-react-header__dropdown-toggle\"]")
    private List<WebElement> navElementsToAssert;

    public WebElement getLanguageFlag() {
        return languageFlag;
    }

    public WebElement getEnglishFlag() {
        return englishFlag;
    }

    public List<WebElement> getNavElementsToAssert() {
        return navElementsToAssert;
    }

    public WebElement getDeutschFlag() {
        return deutschFlag;
    }
}
