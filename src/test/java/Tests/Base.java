package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Utils.BrowserFactory;
import Utils.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class Base {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected TakeScreenshots takeScreenshots;

    @BeforeClass
    public void setUp() {
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

        driver = BrowserFactory.startBrowser("chrome","https://ndosisimplifiedautomation.vercel.app/",headless);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, loginPage);

        takeScreenshots = new TakeScreenshots();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//
//public class Base {
//
//    BrowserFactory browserFactory = new BrowserFactory();
//
//    final WebDriver driver = browserFactory.startBrowser("chrome","https://ndosisimplifiedautomation.vercel.app/");
//
//    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//    TakeScreenshots takeScreenshots = new TakeScreenshots();
//}
