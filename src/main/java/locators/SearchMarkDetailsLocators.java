package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchMarkDetailsLocators {

    @FindBy(css = "[data-se=\"header-nav-link-toggle__hdinf\"]")
    private WebElement info;

    @FindBy(css = "[data-se=\"header-nav-link__hdinfmd\"]")
    private WebElement allCarsAndModels;

    @FindBy(css = ".CardInfo___3YfD_F .btn--link")
    private List<WebElement> listAllCars;

    @FindBy(css = ".titlePrimary___3ZxfWY")
    private WebElement titleOfCars;

    @FindBy(css = ".container-fluid___25vCvC")
    private WebElement titleOfModels;

    @FindBy(css = ".CardInfo___2mHZKr .btn--link")
    private List<WebElement> carModelList;

    @FindBy(css = ".SeriesStage__Title___3n6MmJ")
    private WebElement carNameAndSeries;

    public WebElement getInfo() {
        return info;
    }

    public void setInfo(WebElement info) {
        this.info = info;
    }

    public WebElement getAllCarsAndModels() {
        return allCarsAndModels;
    }

    public void setAllCarsAndModels(WebElement allCarsAndModels) {
        this.allCarsAndModels = allCarsAndModels;
    }

    public List<WebElement> getListAllCars() {
        return listAllCars;
    }

    public void setListAllCars(List<WebElement> listAllCars) {
        this.listAllCars = listAllCars;
    }

    public List<WebElement> getCarModelList() {
        return carModelList;
    }

    public void setCarModelList(List<WebElement> carModelList) {
        this.carModelList = carModelList;
    }

    public WebElement getCarNameAndSeries() {
        return carNameAndSeries;
    }

    public void setCarNameAndSeries(WebElement carNameAndSeries) {
        this.carNameAndSeries = carNameAndSeries;
    }

    public WebElement getTitleOfCars() {
        return titleOfCars;
    }

    public void setTitleOfCars(WebElement titleOfCars) {
        this.titleOfCars = titleOfCars;
    }

    public WebElement getTitleOfModels() {
        return titleOfModels;
    }

    public void setTitleOfModels(WebElement titleOfModels) {
        this.titleOfModels = titleOfModels;
    }
}
