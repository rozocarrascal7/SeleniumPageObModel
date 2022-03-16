package tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class SearchTests {

    WebDriver driver;

    SearchPage searchpages = new SearchPage(driver);
    SearchPage validateenvio = new SearchPage(driver);
    SearchPage reversetitle = new SearchPage(driver);

    @BeforeEach
    public void configurationBrowser() {
       /*
        searchpages.browserUsed();
        searchpages.validateCookiesMessage();

        validateenvio.browserUsed();
        validateenvio.validateCookiesMessage();
        */

        reversetitle.browserUsed();
        reversetitle.validateCookiesMessage();
    }

    /*
    @Test
    public void searchField() throws InterruptedException {
        searchpages.validateTitle();
        searchpages.validateUrl();
        searchpages.sendSearchField();
        searchpages.selectCategories();
        searchpages.selectColor();
        searchpages.validateTitleCategories();
    }

    @Test
    public void validateEnvioGratis() {
        validateenvio.validateTitle();
        validateenvio.validateUrl();
        validateenvio.sendSearchField();
        validateenvio.envioGratis();
    }

   */

    @Test
    public void reverseCategoryTitle() throws InterruptedException {
        reversetitle.sendSearchField();
        reversetitle.selectCategories();
        reversetitle.selectColor();
        reversetitle.reverseTitleCategory();
    }
/*
    @Test
    public void ordenarByList() throws InterruptedException {
        reversetitle.sendSearchField();
        reversetitle.orderBySelector();
    }

 */
    @AfterEach
    public void closeBrowser() {
        //searchpages.closeBrowser();
        //validateenvio.closeBrowser();
       // reversetitle.closeBrowser();
    }
}
