package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {


    private Driver() {}

        public static WebDriver driver;

        public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions optsCh = new ChromeOptions();
                    optsCh.addArguments("-private-window");
                    driver = new ChromeDriver(optsCh);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions optsF = new FirefoxOptions();
                    optsF.addArguments("-private-window");
                    driver =new FirefoxDriver(optsF);
                    break;
                default:
                    System.out.println("Yanlis Browser Ismi Girdiniz.");

            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

        public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
        driver = null;
    }

        public static void waitFor(int timeout) {

        try {
            Thread.sleep(timeout*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    }

