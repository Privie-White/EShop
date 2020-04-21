package myStepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.DressPage;
import pageObjects.LoginPage;
import pageObjects.OrderPage;

import java.util.Random;

public class WebstoreStepDefs
{

    WebDriver driver;
    final static String EMAIL = "fakeemail@fakeremail.com";
    final static String PASSWORD = "fakepassword1234";

    Actions actions;
    Random randNum = new Random();
    DressPage dressPage;


    private final static String URL = "http://automationpractice.com";

    public WebstoreStepDefs(InitializeDriver initializeDriver)
    {
        driver = initializeDriver.getDriver();
        actions = new Actions(driver);
        dressPage = new DressPage(driver);
        driver.get(URL);
    }

    @Given("^Login to the shop with credentials$")
    public void loginToTheShopWithCredentials()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(EMAIL, PASSWORD);
    }

    @When("^User clicks women$")
    public void userClicksWomen()
    {
        dressPage.clickWomen();
    }

    @And("^User adds it to cart$")
    public void userAddsItToCart()
    {
        dressPage.hoverDress();
        dressPage.clickAddToCart();
    }

    @And("^User proceeds to checkout$")
    public void userProceedsToCheckout()
    {
        dressPage.clickProceedToCheckout();
    }


}
