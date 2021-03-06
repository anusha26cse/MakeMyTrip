package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PricingDetails {
    WebDriver driver;
    private By price=By.xpath("//div[@class='pull-left  make_relative price']/p/span");
    private By sort= By.xpath("//div[@class='sortby-dom-sctn price_sorter  active']/span");
    public List<WebElement> GetPrice(){
        return driver.findElements(price);
    }
    public WebElement getSort(){
        return driver.findElement(sort);
    }
    public By price(){
        return price;
    }
}
