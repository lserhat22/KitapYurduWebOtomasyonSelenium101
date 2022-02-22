package com.kitapyurdu.test;

import com.kitapyurdu.drivers.BaseTest;
import com.kitapyurdu.pages.addToFavPage;
import com.kitapyurdu.pages.logInPage;
import org.junit.Test;

public class KitapYurduTest extends BaseTest {

    @Test
    public void fav() {
        logInPage logInPage = new logInPage();
        addToFavPage addToFavPage = new addToFavPage();
        logInPage.logIn();
        addToFavPage.fav();
        addToFavPage.TurkKlasikleri();
    }
}

