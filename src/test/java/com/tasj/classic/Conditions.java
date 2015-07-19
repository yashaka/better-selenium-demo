package com.tasj.classic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

/**
 * Created by yashaka on 7/16/15.
 */
public class Conditions {
    public static ExpectedCondition<Boolean> listNthElementHasText(
            final List<WebElement> list, final int nthElement, final String expectedText){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                try {
                    return list.get(nthElement).getText().contains(expectedText);
                } catch (IndexOutOfBoundsException exception){
                    return false;
                }

            }

            @Override
            public String toString() {
                return String.format("%dth element \nof %s list \nto have text: %s\n", nthElement + 1, list, expectedText);
            }
        };
    }
}
