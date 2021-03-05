package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage
{
public WebDriver driver;
private By From=By.cssSelector(".fsw_inputBox.searchCity.inactiveWidget");
private By DepatureCity=By.xpath("//input[@placeholder='From']");
private By login=By.xpath("//input[@id='username']");
private By DCity=By.cssSelector(".font14.appendBottom5.blackText");
private By LandingContainer=By.cssSelector(".landingContainer  ");
private By ArrivalCity=By.xpath("//input[@placeholder='To']");
private By ACity=By.cssSelector(".font14.appendBottom5.blackText");
private By monthYear=By.cssSelector(".DayPicker-Caption");
private By navigation=By.xpath("//span[@aria-label='Next Month']");
private By dates=By.xpath("//div[@class='dateInnerCell']/p[1]");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getFrom(){
    return driver.findElement(From);
}
public int getLoginSize(){
        return driver.findElements(login).size();
}
public WebElement GetDepatureCity(){
    return driver.findElement(DepatureCity);
}
public List<WebElement> GetDCity(){
        return driver.findElements(DCity);
}
public WebElement getLandingContainer(){
        return driver.findElement(LandingContainer);
}
public WebElement getArrivaicity(){
        return driver.findElement(ArrivalCity);
}
public List<WebElement> getACity(){
        return driver.findElements(ACity);
}
    public WebElement GetMonthYear(){
        return driver.findElement(monthYear);
    }
    public WebElement GetNavigation(){
        return driver.findElement(navigation);
        }
        public List<WebElement> GetDates(){
        return driver.findElements(dates);
    }

}
