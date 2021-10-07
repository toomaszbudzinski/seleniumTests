
import helpers.FileHelper;
import helpers.SystemProperties;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import pages.FastSearchPage;
import pages.LangugaPage;
import pages.SearchMarkDetailsPage;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Tests {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver94.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://mobile.de");
//        FileHelper.createFile(".\\testResult\\");
    }


    @Test
    public void testLanguageOnPage(){
        LangugaPage langugaPage = new LangugaPage(driver,10);
        Properties properties = System.getProperties();
/*      properties.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("-------");*/

        assertThat(langugaPage.getNavigationSearch(), containsString(SystemProperties.getProperty("Suchen")));
        assertThat(langugaPage.getNavigationSell(), containsString(SystemProperties.getProperty("Verkaufen")));
        assertThat(langugaPage.getNavigationInform(), containsString(SystemProperties.getProperty("Informieren")));
    }

    @Test
    @Ignore
    public void searchCarBySimpleSearch() {
        FastSearchPage fastSearchPage = new FastSearchPage(driver, 10);
        fastSearchPage.selectMark("Audi");
        fastSearchPage.selectModel("A4");
        fastSearchPage.selectCity("Berlin");
        fastSearchPage.selectKilometer("100.000 km");
        fastSearchPage.search();
    }

    @Test
    @Ignore
    public void getInformationAboutModel() {
        SearchMarkDetailsPage searchMarkDetailsPage = new SearchMarkDetailsPage(driver, 20);
        searchMarkDetailsPage.searchCarList();
        searchMarkDetailsPage.selectMark("Audi", "Top Marken");
        searchMarkDetailsPage.selectModel("Audi A4", "Audi");
        System.out.println(FileHelper.getFileWriter().getClass());
        FileHelper.writeToFile("Test: getInformationAboutModel() - complete");
        assertThat(searchMarkDetailsPage.getMarkModel(), containsString("Audi A4 (Serie)"));
    }

    @After
    public void tearDown() {
//        FileHelper.closeWriter();
        driver.quit();
    }

    public static boolean verifyElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
            return false;
        }
    }
}
