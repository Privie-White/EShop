package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage
{
    WebDriver driver;
    @FindBy(id="order-list")
    private WebElement orderTable;

    @FindBy(css = "tr.first_item td.history_price span.price")
    private WebElement orderPrice;
    @FindBy(className = "logout")
    private WebElement logout;

    public OrderPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void printOrderRows()
    {
        List<WebElement> orderRows = orderTable.findElements(By.tagName("tr"));
        System.out.println(orderRows.size()-1);
    }

    public String getOrderPrice()
    {
        return orderPrice.getText();
    }

    public void logout()
    {
        logout.click();
    }
}
