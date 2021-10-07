package pages;

import locators.SearchMarkDetailsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchMarkDetailsPage {

    WebDriver driver;
    WebDriverWait wait;
    SearchMarkDetailsLocators search;

    public SearchMarkDetailsPage(WebDriver driver, int timeOut) {
        this.driver = driver;
        search = new SearchMarkDetailsLocators();
        PageFactory.initElements(driver, search);
        wait = new WebDriverWait(driver, timeOut);
    }

    public void searchCarList() {
        search.getInfo().click();
        wait.until(ExpectedConditions.visibilityOf(search.getInfo()));
        search.getAllCarsAndModels().click();
    }

    public void selectMark(String mark, String title) {
        wait.until(ExpectedConditions.textToBePresentInElement(search.getTitleOfCars(), title));
        for (WebElement car : search.getListAllCars()) {
            if (car.getText().contains(mark)) {
                car.click();
                break;
            }
        }
    }

    public void selectModel(String model, String titleOfTheCar) {
        wait.until(ExpectedConditions.textToBePresentInElement(search.getTitleOfModels(), titleOfTheCar));
        for (WebElement car : search.getCarModelList()) {
            if (car.getText().contains(model)) {
                car.click();
                break;
            }
        }
    }

    public String getMarkModel() {
        wait.until(ExpectedConditions.visibilityOf(search.getCarNameAndSeries()));
        return search.getCarNameAndSeries().getText();
    }
}
