package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage
{
    WebDriver driver;
    @FindBy(linkText = "Proceed to checkout")
    private WebElement checkout;
    @FindBy(id = "address_delivery")
    private WebElement deliveryAddress;
    @FindBy(id = "address_invoice")
    private WebElement invoiceAddress;
    @FindBy(name = "processAddress")
    private WebElement processAddress;
    @FindBy(id = "cgv")
    private WebElement cgv;
    @FindBy(name = "processCarrier")
    private WebElement processCarrier;
    @FindBy(id = "total_price")
    private WebElement totalPrice;
    @FindBy(partialLinkText = "Pay by check")
    private WebElement payByCheck;
    @FindBy(css = "button[type='submit']:not([name='submit_search'])")
    private WebElement submit;
    @FindBy(xpath = "//*[@id='center_column']/p[1]")
    private WebElement successText;
    @FindBy(partialLinkText = "Back to orders")
    private WebElement backToOrders;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckout()
    {
        checkout.click();
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress.getText().substring(22);
    }

    public String getInvoiceAddress()
    {
        return invoiceAddress.getText().substring(21);
    }

    public void clickProcessAddress()
    {
        processAddress.click();
    }

    public void clickCgv()
    {
        cgv.click();
    }

    public void clickProcessCarrier()
    {
        processCarrier.click();
    }

    public String getTotalPrice()
    {
        return totalPrice.getText();
    }

    public void clickPayByCheck()
    {
        payByCheck.click();
    }

    public void clickConfirmOrder()
    {
        submit.click();
    }

    public String getMessageText()
    {
        return successText.getText();
    }

    public void clickBackToOrders()
    {
        backToOrders.click();
    }
}
