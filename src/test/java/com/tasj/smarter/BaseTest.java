package com.tasj.smarter;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by yashaka on 7/16/15.
 */
public class BaseTest extends ConciseAPI {
    static WebDriver driver = new FirefoxDriver();

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
