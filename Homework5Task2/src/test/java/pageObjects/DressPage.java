package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class DressPage
{
    WebDriver driver;
    Random randNum;
    Actions actions;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li/a[text() = 'Women']")
    private WebElement women;
    @FindBys(@FindBy( className = "product-container"))
    private List<WebElement> dresses;
    @FindBy(linkText = "Add to cart")
    private WebElement addToCart;
    @FindBy(linkText = "Proceed to checkout")
    private WebElement checkout;


    public DressPage(WebDriver driver)
    {
        this.driver = driver;
        randNum = new Random();
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickWomen()
    {
        women.click();
    }

    public void hoverDress()
    {
        int randDress = randNum.nextInt(dresses.size());
        WebElement dressProductLink = dresses.get(randDress);
        actions.moveToElement(dressProductLink).build().perform();
    }

    public void clickAddToCart()
    {
        addToCart.click();
    }

    public void clickProceedToCheckout()
    {
        checkout.click();
    }
}
