package StepDefination;

import PageObjects.HomePage;
import PageObjects.PricingDetails;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BaseClass;
import resources.dataDriven;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyStepDefinations extends BaseClass {
    WebDriver driver;
    @Given("^Navigate to (.+)$")
    public void navigate_to(String url) throws Throwable {
        driver = initializerDriver();
        driver.get(url);
    }

    HomePage hp;
    dataDriven dd;
    ArrayList data;
    int strlen;
    String city;
List<WebElement> options;
    @When("^Select DepatureCity$")
    public void select_depaturecity() throws Throwable {
        hp = new HomePage(driver);
        if (hp.getLoginSize() > 0) {
            hp.getLandingContainer().click();
        }
        hp.getFrom().click();
        dd = new dataDriven();
        data = dd.getData("Depature City");
        hp.GetDepatureCity().sendKeys((CharSequence) data.get(1));
        Thread.sleep(3000);
        options=hp.GetDCity();
        for(WebElement option :options){
            strlen=String.valueOf(data.get(1)).length();
            city=option.getText().substring(0,strlen);
            if(city.equalsIgnoreCase(String.valueOf(data.get(1)))){
                option.click();
                break;
            }
        }
    }

    @And("^Select ArrivalCity$")
    public void select_arrivalcity() throws Throwable {
        data = dd.getData("Arrival City");
        hp.getArrivaicity().sendKeys(String.valueOf(data.get(1)));
        Thread.sleep(3000);
        options=hp.getACity();
        for(WebElement option :options){
            strlen = String.valueOf(data.get(1)).length();
            city = option.getText().substring(0, strlen);
            if (city.equals(String.valueOf(data.get(1)))) {
                option.click();
                break;
            }
        }
    }
    LocalDate givenDate;
    int reqDate;
    String reqMonthYear;
    @And("^Select Depature Date$")
    public void select_depature_date() throws Throwable {
        data = dd.getData("Depature Date");
        String rDate = String.valueOf(data.get(1));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        givenDate = LocalDate.parse(rDate);
        boolean tday = LocalDate.parse(rDate).isBefore(LocalDate.now());
        Assert.assertFalse(tday);
        reqDate = givenDate.getDayOfMonth();
        String reqMonth = String.valueOf(givenDate.getMonth());
        String reqYear = String.valueOf(givenDate.getYear());
        reqMonthYear = reqMonth.substring(0, 1).concat(reqMonth.substring(1, reqMonth.length()).toLowerCase()).concat(" ").concat(reqYear);
        while (true) {
            if (hp.GetMonthYear().getText().equalsIgnoreCase(reqMonthYear)) {
                int count = hp.GetDates().size();
                for (int i = 0; i < count; i++) {
                    if (hp.GetDates().get(i).getText().equalsIgnoreCase(String.valueOf(reqDate))) {
                        hp.GetDates().get(i).click();
                        break;
                    }
                }
                break;
            } else
                hp.GetNavigation().click();
        }
    }
    @Then("^Select the No of travellers$")
    public void select_the_no_of_travellers() throws Throwable {
        hp.GetTandC().click();
        data = dd.getData("Adults");
        int AdultsCount = hp.getAdults().size();
        if (Integer.parseInt(String.valueOf(data.get(1))) <= 9) {
            for (int i = 0; i < AdultsCount - 1; i++) {
                if (hp.getAdults().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1)))) {
                    hp.getAdults().get(i).click();
                    break;
                }
            }
        }
        else {
            hp.getAdults().get(AdultsCount-1).click();
        }
        data=dd.getData("Children");
        int ChildernCount= hp.getChildern().size();
        if(Integer.parseInt(String.valueOf(data.get(1)))<=6)
        {
            for(int i=0;i<ChildernCount-1;i++){
                if(hp.getChildern().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1)))){
                    hp.getChildern().get(i).click();
                    break;
                }
            }
        }
        else
            hp.getChildern().get(ChildernCount-1).click();
        data=dd.getData("InFants");
     int infants=hp.getInfants().size();
     Assert.assertTrue(Integer.parseInt(String.valueOf(dd.getData("Adults").get(1)))>Integer.parseInt(String.valueOf(dd.getData("InFants").get(1))));
     if(Integer.parseInt(String.valueOf(data.get(1)))<=6){
         for(int i=0;i<infants-1;i++){
             if(hp.getInfants().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1)))){
                 hp.getInfants().get(i).click();
             }
         }
     }
     else
         hp.getInfants().get(infants-1).click();
    }
    @And("^Select Class of Travelling$")
    public void select_class_of_travelling() throws Throwable {
       data=dd.getData("TravelClass");
       int TravelClassCount=hp.GetTravelClass().size();
       for(int i=0;i<TravelClassCount;i++) {
           if (hp.GetTravelClass().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1)))){
               hp.GetTravelClass().get(i).click();
               break;
           }
       }
       hp.getApplyBtn().click();
    }
    @And("^Select Type of Fare$")
    public void select_type_of_fare() throws Throwable {
data=dd.getData("Type of Fare");
int fareCount=hp.getFareBtn().size();
for(int i=0;i<fareCount;i++) {
    if (hp.getFareBtn().get(i).getText().equalsIgnoreCase(String.valueOf(data.get(1)))) {
        hp.getFareBtn().get(i).click();
        break;
    }
}
    }
    PricingDetails pd;
    WebDriverWait wait;
    @And("^Search for the flights$")
    public void search_for_the_flights() throws Throwable {
        hp.GetSearchBtn().click();
        Thread.sleep(3000);
        pd=new PricingDetails(driver);
        wait= new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(pd.getSortBY()));
        Thread.sleep(3000);

        if(pd.getSort().isDisplayed())
        {
         pd.getSort().click();
        }
        else
        {
pd.GetBuyNow().click();
        }


    }
}