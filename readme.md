# This is a notes project from the 3 hours demo on building Selenium Based Test Frameworks (Selenium Wrappers)

## Goal

### In short

Develop fast (around 3 hours, or less) a Selenium wrapper in java, in order to

**I**

be able to write straigtforward code:

```java

        open("http://google.com/ncr");
        $(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        $("#rhs_block a").click();
        assertThat(valueOf($(By.name("q")), "selenium element"));
```

almost the same way as in [selenide](selenide.org):

```java

        open("http://google.com/ncr");
        $(By.name("q")).setValue("Selenium").pressEnter();
        $("#rhs_block a").click();
        $(By.name("q")).shouldHave(value("selenium element"));
```

instead of raw selenium's

```java

    WebDriver driver = new FirefoxDriver();
    ...
        driver.get(http://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        (new WebDriverWait(driver, 4)).until(visibilityOfElementLocated(By.cssSelector("#rhs_block a")).click();
        (new WebDriverWait(driver, 4)).until(textToBePresentInElementValue(By.name("q"), "selenium element"));
    ...
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
    
```

**II**

use simpler PageObjects

```java

public class GooglePage extends BasePage {

    WebElement resultsStats = $("#resultStats");
    
    List<WebElement> results = $$(".srg .g");
```

instead of raw Selenium's PageObjects with PageFactories

```java

public class GooglePage extends BasePage {

    @FindBy(id = "resultStats")
    WebElement resultsStats;

    @FindBy(css = ".srg .g")
    List<WebElement> results;
```

### More

The goal is to provide the same as Selenide does:

> - Concise API for tests
> - Ajax support
> - True Page Objects
> - jQuery-style selectors

> (c) [selenide.org](http://selenide.org)


In order to make API more concise, the "selenide notation" is used: 

- `$` finds element
- `$$` finds all elements
- `open` loads the page by url

Under "True PageObjects" - the "simpler DSL for PageObjects" is meant, i.e. without bulky @FindBy syntax. 

The main benefit is of course - the Ajax support. Tha latter is implemented via 

- smart implicit waiting for visibility of the element (instead of waiting for only "existance in DOM" in raw selenium)
- handy explicit waits built in assertions

For simplicity of this Demo, the structure of the framework is very simple and basic, 

- without breakdown into common "core, pages, tests, etc" packages
- with some core classes used only once - implemented as Inner Classes.

## Structure and Approaches

The only structuring is the breakdown into 3 versions of framework. This versions live in correspondent packages and reflect the following approach:

### classic

_"Demos the basic Selenium utilities but with more concise API"_
  - Using classic selenium PageObjects and PageFactory plus some concise (though not smart) helpers

  
### simpler

_"Achives simplicity of usage with a minimum of time and knowledge spent for framework development"_

- Using PageObjects with fields as locators, not webelements, in order to:

    - achieve "lazyness" of "finding elements" in explicit waits
    - simplify the PageObject (via removing bulky @FindBy-s)
    - simplify the framework itself


### smarter

_"Adds more power and efficiency via some java magic with more knowledge and time applied"_

- Using PageObjects with fields as webelements decorated with a lazy proxy smart finders
  
    - but more handy in usage: you can decorate WebElement anywhere you want (not only inside PageObject with @FindBy anotation)
    - and without bulky @FindBy-s :)
    - "smart" stands for "wait by default for visibility of elements"
    
## Todos

- add more details and docs
- add comments to the code
- refactor $get method to be of OOP style