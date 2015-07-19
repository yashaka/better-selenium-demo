package com.tasj.classic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by yashaka on 7/18/15.
 */
public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    public WebElement find(By locator){
        return getWebDriver().findElement(locator);
    }

    public WebElement find(String cssSelector){
        return getWebDriver().findElement(By.cssSelector(cssSelector));
    }

    public List<WebElement> findAll(By locator){
        return getWebDriver().findElements(locator);
    }

    public List<WebElement> findAll(String cssSelector){
        return getWebDriver().findElements(By.cssSelector(cssSelector));
    }

    public void open(String url){
        getWebDriver().get(url);
    }

    public void waitUntil(int timeout, ExpectedCondition<?> condition){
        (new WebDriverWait(getWebDriver(), timeout)).until(condition);
    }

    public void assertThat(ExpectedCondition<?> condition){
        waitUntil(Configuration.timeout, condition);
    }
}
