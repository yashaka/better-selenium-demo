package com.tasj.classic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by yashaka on 7/16/15.
 */
public class GooglePage extends BasePage {

    @FindBy(css = ".srg .g")
    List<WebElement> results;

    public void visit(){
        open("http://google.com/ncr");
    }

    public void search(String text){
        find(By.name("q")).sendKeys(text, Keys.ENTER);
    }

    public GooglePage(WebDriver driver){
        super(driver);
    }

}
