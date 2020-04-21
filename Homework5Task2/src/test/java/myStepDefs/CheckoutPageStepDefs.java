package myStepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.OrderPage;

public class CheckoutPageStepDefs
{
    WebDriver driver;
    CheckoutPage checkoutPage;
    OrderPage orderPage;
    String expectedOrderPrice;
    final static String expectedSuccessText = "Your order on My Store is complete.";
    public CheckoutPageStepDefs(InitializeDriver initializeDriver)
    {
        driver = initializeDriver.getDriver();
        checkoutPage = new CheckoutPage(driver);
        orderPage = new OrderPage(driver);
    }

    @And("^User hits checkout again$")
    public void userHitsCheckoutAgain()
    {
        checkoutPage.clickCheckout();
    }

    @And("^Delivery addresses are checked to match$")
    public void deliveryAddressesAreCheckedToMatch()
    {
        String deliveryAddress = checkoutPage.getDeliveryAddress();
        String invoiceAddress = checkoutPage.getInvoiceAddress();
        Assert.assertEquals(deliveryAddress, invoiceAddress);
    }

    @And("^User proceeds to checkout again$")
    public void userProceedsToCheckoutAgain()
    {
        checkoutPage.clickProcessAddress();
    }

    @And("^user agrees to terms and services$")
    public void userAgreesToTermsAndServices()
    {
        checkoutPage.clickCgv();
    }

    @And("^User proceeds to checkout a third time$")
    public void userProceedsToCheckoutAThirdTime()
    {
        checkoutPage.clickProcessCarrier();
        expectedOrderPrice = checkoutPage.getTotalPrice();
    }

    @And("^user clicks pay by check$")
    public void userClicksPayByCheck()
    {
        checkoutPage.clickPayByCheck();
    }

    @And("^user confirms order$")
    public void userConfirmsOrder()
    {
        checkoutPage.clickConfirmOrder();
    }

    @And("^Verify order is submitted$")
    public void verifyOrderIsSubmitted()
    {
        String actualSuccessText = checkoutPage.getMessageText();
        Assert.assertEquals(actualSuccessText, expectedSuccessText);
    }

    @And("^user goes back to order$")
    public void userGoesBackToOrder()
    {
        checkoutPage.clickBackToOrders();
    }

    @And("^number of orders is printed$")
    public void numberOfOrdersIsPrinted()
    {
        orderPage.printOrderRows();
    }

    @And("^Verify price of last order matches last order made$")
    public void verifyPriceOfLastOrderMatchesLastOrderMade()
    {
        String actualOrderPrice = orderPage.getOrderPrice();
        Assert.assertEquals(actualOrderPrice, expectedOrderPrice);
    }

    @Then("^Logout$")
    public void logout()
    {
        orderPage.logout();
    }
}
