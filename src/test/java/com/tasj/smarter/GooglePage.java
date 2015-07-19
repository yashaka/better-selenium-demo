package com.tasj.smarter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by yashaka on 7/16/15.
 */
public class GooglePage extends BasePage {


    WebElement resultsStats = $("#resultStats");
    List<WebElement> results = $$(".srg .g");

    public void visit(){
        open("http://google.com/ncr");
    }

    public void search(String text){
        $(By.name("q")).sendKeys(text, Keys.ENTER);
    }

    public void followResult(int index){
        $get(results, index).findElement(By.cssSelector("h3>a")).click();
    }

    public GooglePage(WebDriver driver){
        super(driver);
    }

}
