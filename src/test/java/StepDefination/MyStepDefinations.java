package StepDefination;

import PageObjects.HomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import resources.BaseClass;
import resources.dataDriven;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        int depatureCityCount = hp.GetDCity().size();
        for (int i = 0; i <= depatureCityCount; i++) {
            strlen = String.valueOf(data.get(1)).length();
            city = hp.GetDCity().get(i).getText().substring(0, strlen);
            if (city.equals(String.valueOf(data.get(1)))) {
                hp.GetDCity().get(i).click();
                break;
            }
        }
    }

    @And("^Select ArrivalCity$")
    public void select_arrivalcity() throws Throwable {
        data = dd.getData("Arrival City");
        hp.getArrivaicity().sendKeys(String.valueOf(data.get(1)));
        int ArrialCityCount = hp.getACity().size();
        for (int i = 0; i < ArrialCityCount; i++) {
            strlen = String.valueOf(data.get(1)).length();
            city = hp.getACity().get(i).getText().substring(0, strlen);
            if (city.equals(String.valueOf(data.get(1)))) {
                hp.getACity().get(i).click();
                break;
            }
        }
    }
    LocalDate givenDate;
int reqDate;
String reqMonthYear;
    @And("^Select Depature Date And return Date$")
    public void select_depature_date_and_return_date() throws Throwable {
        data = dd.getData("Depature Date");
        //System.out.println(data.get(1));
String rDate=String.valueOf(data.get(1));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        givenDate= LocalDate.parse(rDate);
boolean tday=LocalDate.parse(rDate).isBefore(LocalDate.now());
Assert.assertFalse(tday);
        reqDate = givenDate.getDayOfMonth();
        String reqMonth=String.valueOf(givenDate.getMonth());
        String reqYear=String.valueOf(givenDate.getYear());
        reqMonthYear=reqMonth.substring(0,1).concat(reqMonth.substring(1,reqMonth.length()).toLowerCase()).concat(" ").concat(reqYear);
        while(true) {
            if (hp.GetMonthYear().getText().equalsIgnoreCase(reqMonthYear)) {
                System.out.println(hp.GetMonthYear().getText());
                int count = hp.GetDates().size();
                for (int i = 0; i < count; i++) {
                    System.out.println("Date is"+hp.GetDates().get(i).getText());
                    if (hp.GetDates().get(i).getText().equalsIgnoreCase(String.valueOf(reqDate))) {
                        System.out.println(hp.GetDates().get(i));
                        hp.GetDates().get(i).click();
                        break;
                    }
                }
break;
            } else
                hp.GetNavigation().click();
        }

    }



    @Then("^Search for the city$")
    public void search_for_the_city() throws Throwable {

    }



}
