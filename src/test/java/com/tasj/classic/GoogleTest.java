package com.tasj.classic;

import org.junit.Test;

import static com.tasj.classic.Conditions.listNthElementHasText;

/**
 * Created by yashaka on 7/16/15.
 */
public class GoogleTest extends BaseTest {

    GooglePage page = new GooglePage(driver);

    {
        Configuration.timeout = 8;
    }

    @Test
    public void testGoogleSearch(){

        page.visit();
        page.search("Selenium");
        assertThat(listNthElementHasText(page.results, 9, "Detailed instructions for Windows users"));
    }

}
