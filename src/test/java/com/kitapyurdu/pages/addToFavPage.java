package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class addToFavPage {
    Methods methods;

    public addToFavPage() {
        methods = new Methods();
    }

    public void fav() {
        methods.sendKey(By.id("search-input"), "Oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        List<WebElement> product = methods.FindElements(By.cssSelector(".product-details"));//scroll yaptır
        WebElement yedinciurun = product.get(7);
        methods.scrollWithAction(yedinciurun);
        methods.addToFavorite();//fav ekle
        methods.favCheck();//Favorileri KONTROL et
        methods.click(By.cssSelector(".logo-text"));//Homepage gider
    }

    public void TurkKlasikleri() {
        //sıralama yapar
        methods.click(By.cssSelector("#mainNav > div.nav-content > div > div.lvl1catalog > a"));
        methods.waitBySeconds(1);
        methods.click(By.cssSelector("#landing-point > div:nth-child(4) > a:nth-child(2) > img"));
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".sort > select"));
        methods.waitBySeconds(1);
        methods.selectByText(By.cssSelector(".sort > select"), "Yüksek Oylama");
        methods.waitBySeconds(1);
        //
        //Hobi için
        //
        methods.scrollWithAction(By.cssSelector(".lvl2.js-bookCr > ul > li:nth-child(3) > span"));
        methods.waitBySeconds(1);
        methods.clickJS(By.cssSelector(":nth-child(3) > :nth-child(14) > a"));
        methods.waitBySeconds(1);
        //
        //Random urun secıp sepete ekle
        //
        methods.ClickRandomProduct();
        methods.waitBySeconds(1);
        methods.click(By.id("button-cart"));
        methods.waitBySeconds(1);
        //
        //Listelerim > favoriler girer
        //
        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.waitBySeconds(1);
        methods.click(By.linkText("Favorilerim"));
        methods.waitBySeconds(1);
        //
        //favorilerden 3. ögeyi siler
        //
        methods.click(By.xpath("(//*[@data-title='Favorilerimden Sil'])[3]"));
        methods.waitBySeconds(1);
        //
        //Sepete git
        //
        methods.click(By.cssSelector("#cart-items"));
        methods.waitBySeconds(1);
        methods.click(By.cssSelector("#js-cart"));
        methods.waitBySeconds(1);
        //
        //Ürün adeti arttır
        //
        methods.sendKey(By.cssSelector("#cart_module > div.cart-info > table > tbody > tr > td.quantity > form > input[type=text]:nth-child(1)"), "0");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".fa.fa-refresh.green-icon"));
        methods.waitBySeconds(1);
        //
        //Ürün Satın Al Tıkla
        //
        methods.click(By.cssSelector("#cart_module > div.buttons > div.right > a"));
        methods.waitBySeconds(1);
        //
        //Yeni Adres kaydı
        //
        methods.click(By.cssSelector("#shipping-tabs > a:nth-child(2)"));
        methods.waitBySeconds(1);
        //
        //Adres Bilgileri gir
        //
        methods.sendKey(By.cssSelector("#address-firstname-companyname"), "DenemeAd");
        methods.waitBySeconds(1);
        methods.sendKey(By.cssSelector("#address-lastname-title"), "DenemeSoyad");
        methods.waitBySeconds(1);
        methods.selectByValue(By.cssSelector("#address-zone-id"), "3354");
        methods.waitBySeconds(1);
        methods.selectByValue(By.cssSelector("#address-county-id"), "465");
        methods.waitBySeconds(1);
        methods.sendKey(By.cssSelector("#address-address-text"), "Adres deneme deneme");
        methods.waitBySeconds(1);
        methods.sendKey(By.cssSelector("#address-mobile-telephone"), "5555555555");
        methods.waitBySeconds(1);
        //
        //Devam1-Devam2
        //
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(1);
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(1);
        //
        //Kart Bilgileri Gir
        //
        methods.sendKey(By.cssSelector("#credit-card-owner"), "DenemeAd DenemeSoyad");
        methods.waitBySeconds(1);
        methods.sendKey(By.cssSelector("#credit_card_number_1"), "1234");
        methods.sendKey(By.cssSelector("#credit_card_number_2"), "1234");
        methods.sendKey(By.cssSelector("#credit_card_number_3"), "1234");
        methods.sendKey(By.cssSelector("#credit_card_number_4"), "1234");
        methods.waitBySeconds(1);
        methods.selectByValue(By.cssSelector("#credit-card-expire-date-month"), "01");
        methods.selectByValue(By.cssSelector("#credit-card-expire-date-year"), "2024");
        methods.waitBySeconds(1);
        methods.sendKey(By.cssSelector("#credit-card-security-code"), "123");
        //
        //DevamSon
        //
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(1);
        String errorText = methods.getText(By.cssSelector("#form-credit-card > div.credit-card-form-content > table > tbody > tr:nth-child(5) > td > span"));
        if (errorText != null) {
            System.out.println(errorText);
            methods.click(By.cssSelector("#logo > a > img"));//Homepage
            //Logout
            methods.scrollWithAction(By.cssSelector("#header-top > div > div.welcome.fl > div.menu.top.login > ul > li > a"));
            methods.clickJS(By.cssSelector("#header-top > div > div.welcome.fl > div.menu.top.login > ul > li > div > ul > li:nth-child(4) > a"));
        } else if (errorText == null) {
            System.out.println("Satın alma işlemi gerçekleşiyor.");
        }
        methods.waitBySeconds(1);
    }
}


