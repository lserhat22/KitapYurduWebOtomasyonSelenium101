package com.kitapyurdu.methods;

import com.kitapyurdu.drivers.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(60)).
                pollingEvery(Duration.ofMillis(300)).
                ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    private WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void clickJS(By by) {
        jsdriver.executeScript("arguments[0].click();", findElement(by));
    }

    public void sendKey(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
            return true;
        } catch (Exception e) {
            logger.info("False" + e.getMessage());
            return false;
        }
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    //FINDELEMENT
    public List<WebElement> FindElements(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElements(element);
    }


    public String getText(By by) {
        return findElement(by).getText();
    }

    public void scrollWithAction(WebElement element) { //Sayfada kaydırmak için
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void scrollWithAction(By by) { //Sıralama için
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public void selectByValue(By by, String text) {
        getSelect(by).selectByValue(text);

    }

    public void ClickRandomProduct() {
        Random rnd = new Random();
        List<WebElement> Products = findElements(By.cssSelector(".cover"));
        WebElement rndProduct = Products.get(rnd.nextInt(Products.size()));
        rndProduct.click();
    }


    private ISelect getSelect(By by) {
        return new Select(findElement(by));
    }

    public List<WebElement> findElements(By by) {
        wait.until((ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
        return driver.findElements(by);
    }

    public void addToFavorite() {

        List<WebElement> products = findElements(By.cssSelector(".add-to-favorites"));

        for (int i = 2; i < 6; i++) {
            WebElement el = products.get(i);
            scrollWithAction(el);
            products.get(i).click();

        }
    }

    public void favCheck() {
        click(By.cssSelector(".menu.top.my-list"));
        click(By.linkText("Favorilerim"));
        Assert.assertTrue(isElementVisible(By.cssSelector(".limit")));
    }

}

