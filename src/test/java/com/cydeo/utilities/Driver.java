package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //we create a private constructor, so we are closing access to the object of this class from outside
    private Driver(){

    }


    /*
   We make WebDriver private, because we want to close access from outside the class.
   We make it static because we will use it in a static method.
    */
   // private static WebDriver driver;  // value is null by default

    private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>();


    /*
  Create a re-usable utility method which will return same driver instance when we call it
   */
    public static WebDriver getDriver() {

        if (Driver.driverPool.get() ==null) {

            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");


            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    Driver.driverPool.set(new ChromeDriver());
                    Driver.driverPool.get().manage().window().maximize();
                    Driver.driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    Driver.driverPool.set(new FirefoxDriver());
                    Driver.driverPool.get().manage().window().maximize();
                    Driver.driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }


        }
        return Driver.driverPool.get();
    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (Driver.driverPool.get() != null){
            Driver.driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
            Driver.driverPool.remove();
        }
    }
}
