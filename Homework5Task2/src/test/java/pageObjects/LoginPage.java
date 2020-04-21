package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoginPage
{
    WebDriver driver;
    @FindBy(linkText = "Sign in")
    private WebElement signin;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "passwd")
    private WebElement password;
    @FindBy(id = "SubmitLogin")
    private WebElement submit;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email)
    {
        WebElement emailInput = this.email;
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPassword(String password)
    {
        WebElement passwdInput = this.password;
        passwdInput.clear();
        passwdInput.sendKeys(password);
    }

    public void clickSubmit()
    {
        submit.click();
    }

    public void doLogin(String username, String password)
    {
        signin.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.setEmail(username);
        this.setPassword(password);
        clickSubmit();
    }
}
