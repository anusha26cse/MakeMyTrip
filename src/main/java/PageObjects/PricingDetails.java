package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PricingDetails {
    public WebDriver driver;
   By price=By.xpath("//div[@class='pull-left  make_relative price']/p/span");
   By SortBy=By.xpath("//div[@id='left-side-header--wrapper']");
   By sort=By.xpath("//span[@class='up sort-arrow']");
   By BuyNow=By.xpath("//button[@class='fli_primary_btn  text-uppercase ']");
    public PricingDetails(WebDriver driver) {
        this.driver = driver;
    }
    public List<WebElement> getPrices(){ return driver.findElements(price);
    }
    public WebElement getSortBY(){
        return driver.findElement(SortBy);
    }
    public WebElement getSort(){
        return driver.findElement(sort);
    }
    public WebElement GetBuyNow(){
        return driver.findElement(BuyNow);
    }


}
