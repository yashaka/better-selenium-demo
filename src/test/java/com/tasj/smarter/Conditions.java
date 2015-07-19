package com.tasj.smarter;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by yashaka on 7/16/15.
 */
public class Conditions {
    public static ExpectedCondition<Boolean> listNthElementHasText(
            final List<WebElement> list, final int nthElement, final String expectedText){
        return new ExpectedCondition<Boolean>() {
            private String nthElementText = "";

            public Boolean apply(WebDriver input) {
                try {
                    nthElementText = list.get(nthElement).getText();
                    return nthElementText.contains(expectedText);
                } catch (IndexOutOfBoundsException exception){
                    return false;
                }

            }

            @Override
            public String toString() {
                return String.format("%dth element \nof %s list \nto have text: %s\n while actual text is: %s\n"
                        , nthElement + 1, list, expectedText, nthElementText);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> listSizeIsAtLeast(final List<WebElement> list, final int minimumSize){
        return new ExpectedCondition<List<WebElement>>() {
            public List<WebElement> apply(WebDriver input) {
                return list.size() >= minimumSize ? list : null;
            }
        };
    }

    public static ExpectedCondition<Boolean> textIn(final WebElement element, final String containableText){
        return new ExpectedCondition<Boolean>() {
            private String elementText = "";

            public Boolean apply(WebDriver driver) {
                try {
                    elementText = element.getText();
                    return elementText.contains(containableText);
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return String.format("text ('%s') to be present in element %s\n while actual text is: %s\n", containableText, element, elementText);
            }
        };
    }

    /*
         ALIASES
     */

    public static ExpectedCondition<Boolean> valueOf(WebElement element, String containableText){
        return ExpectedConditions.textToBePresentInElementValue(element, containableText);
    }

    public static ExpectedCondition<WebElement> visible(WebElement element){
        return ExpectedConditions.visibilityOf(element);
    }

    public static ExpectedCondition<WebElement> visible(By elementLocator){
        return ExpectedConditions.visibilityOfElementLocated(elementLocator);
    }
}
