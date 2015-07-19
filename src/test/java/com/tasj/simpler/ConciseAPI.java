package com.tasj.simpler;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.tasj.simpler.Conditions.listSizeIsAtLeast;
import static com.tasj.simpler.Conditions.visible;

/**
 * Created by yashaka on 7/18/15.
 */
public abstract class ConciseAPI {

    public abstract WebDriver getWebDriver();

    protected WebElement $(By locator){
        return assertThat(visible(locator));
    }

    protected WebElement $(String cssSelector){
        return $(By.cssSelector(cssSelector));
    }

    protected List<WebElement> $$(By locator){
        return getWebDriver().findElements(locator);
    }

    protected List<WebElement> $$(String cssSelector){
        return $$(By.cssSelector(cssSelector));
    }

    protected WebElement $get(By listLocator, int index){
        return assertThat(listSizeIsAtLeast(listLocator, index + 1)).get(index);
    }

    protected void open(String url){
        getWebDriver().get(url);
    }

    protected <V> V waitUntil(Function<? super WebDriver, V> condition, int timeout){
        return (new WebDriverWait(getWebDriver(), timeout)).until(condition);
    }

    protected <V> V assertThat(Function<? super WebDriver, V> condition){
        return waitUntil(condition, Configuration.timeout);
    }
}
