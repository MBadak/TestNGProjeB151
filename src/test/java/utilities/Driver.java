package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
/*
POM(Page Object Model)
    Test senaryolarının daha az kod ile yazılmasına ve bakımının daha kolay yapılmasına
olanak sağlayan yazılım test yöntemidir. TestNG de ve CUCUMBER da POM kalıbını kullanırız
 */

public class Driver {
    private  Driver(){
        /*
        Driver class'ından obje oluşturmanın önüne geçmek için
        default constructor'ı private yaparak bunun önüne geçebiliriz
         */
    }
    static WebDriver driver;
    /*
             Driver'i her cagirdigimizda yeni bir pencere acilmasinin onune gecmek icin if blogu icinde Eger driver'a
             deger atanmamissa deger ata , eger deger atanmissa Driver'i ayni sayfada return et
             */
    public static WebDriver getDriver() {
        if (driver == null) {

         switch (ConfigReader.getProperty("browser")){
             case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
             case "edge":
                 WebDriverManager.edgedriver().setup();
                 driver = new EdgeDriver();
                 break;
             case "firefox":
                 WebDriverManager.firefoxdriver().setup();
                 driver = new FirefoxDriver();
                 break;
             case "safari":
                 WebDriverManager.safaridriver().setup();
                 driver = new SafariDriver();
                 break;
             default:
                 WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();

         }



            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }


    public static void closeDriver() {
        if(driver != null){//-->driver'a deger ATANMISSA
            driver.close();
            driver = null;//-->driver'i kapattiktan sonra bosalt
        }
    }


    public static void quitDriver() {
        if (driver != null) {//-->driver'a deger ATANMISSA
            driver.quit();
            driver = null;//-->driver'i kapattiktan sonra bosalt
        }
    }
}

