package resources;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    public Properties prop;
    String CurrentDir=System.getProperty("user.dir");
    public WebDriver initializerDriver() throws IOException {
        prop = new Properties();

        FileInputStream fis = new FileInputStream(CurrentDir+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if (browserName.equals("InternetExplorer")) {
            //execute in InternetExplorer driver
            System.setProperty("webdriver.ie.driver", CurrentDir+"\\src\\main\\java\\resources\\IEDriverServer.exe");

            driver = new InternetExplorerDriver();
        } else if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver",CurrentDir+"\\src\\main\\java\\resources\\chromedriver.exe");
//ChromeOptions options= new ChromeOptions();
//options.addArguments("headless");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", CurrentDir+"\\src\\main\\java\\resources\\geckodriver.exe");

            //create driver object for chrome brower
            // classname=ChromeDriver
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    return driver;
    }
}
