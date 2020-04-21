package myStepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeDriver
{
    private WebDriver driver;


    @Before
    public void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void closeDriver()
    {
        driver.quit();
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
