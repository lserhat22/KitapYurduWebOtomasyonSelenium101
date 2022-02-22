package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class logInPage {
    Methods methods;
    Logger logger = LogManager.getLogger(logInPage.class);


    public logInPage() {
        methods = new Methods();
    }

    public void logIn() {
        methods.click(By.cssSelector(".menu-top-button.login>a"));
        methods.sendKey(By.id("login-email"), "s_buyukada@testinium.com");
        methods.sendKey(By.id("login-password"), "1q2w3e4r5t");
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".section")));
        String checkText = methods.getText(By.cssSelector("#content.grid_12.mg-b-30.account-menu>h1"));
        System.out.println("Alınan textt: " + checkText);
        logger.info("Alınan textt: " + checkText);
        Assert.assertEquals("Hesabım", checkText);

    }
}
