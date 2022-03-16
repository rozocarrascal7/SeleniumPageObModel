package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SearchPage {

    By searchField = By.id("cb1-edit");
    By botasBotinesOption = By.xpath("//*[contains(text(), 'Botas y Botines')]");
    By cookiesMessage = By.xpath("//button[@class='cookie-consent-banner-opt-out__action cookie-consent-banner-opt-out__action--primary cookie-consent-banner-opt-out__action--key-accept']");
    By blackColorOption = By.id("Negro");
    By titleCategories = By.xpath("//h1[@class='ui-search-breadcrumb__title']");
    By envioGratisCheckBox = By.xpath("//*[contains(text(), 'Envío gratis')]");
    By selection = By.xpath("//*[@class='andes-dropdown__standalone-arrow']");
    By orderByvalue = By.xpath("//div[contains(text(),'Menor precio')]");


    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void browserUsed() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.co/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    }

    public void validateTitle() {
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Mercado Libre Colombia - Envíos Gratis en el día");
    }

    public void validateUrl() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://www.mercadolibre.com.co/");
    }

    public void validateCookiesMessage() {
        driver.findElement(cookiesMessage).click();
    }

    public void sendSearchField() {
        driver.findElement(searchField).sendKeys("Zapatos", Keys.ENTER);
    }

    public void selectCategories() {
        driver.findElement(botasBotinesOption).click();
    }

    public void selectColor() throws InterruptedException {
        driver.findElement(blackColorOption).click();
        Thread.sleep(2000);
    }

    public void validateTitleCategories() {
        String tituloCategoria = driver.findElement(titleCategories).getText();
        System.out.println("El titulo de la categoria es: " + tituloCategoria);
        Assertions.assertEquals(tituloCategoria, "Zapatos");
    }

    public void reverseTitleCategory(){
        String tituloCategoria = driver.findElement(titleCategories).getText();
        System.out.println("El titulo de la categoria es: " + tituloCategoria);

        String nuevo = "";
        char ch;

        for (int i=0; i<tituloCategoria.length(); i++){
            ch=tituloCategoria.charAt(i);
            nuevo=ch+nuevo;
        }
        System.out.println("El valor reversado del titulo de la categoria es:"+ nuevo);

        String UpperCase = nuevo.toUpperCase();
        System.out.println("El valor del nuevo titulo está en mayusculas: " + UpperCase );
    }

    public void envioGratis() {
        WebElement checkButton = driver.findElement(envioGratisCheckBox);
        checkButton.isDisplayed();
        checkButton.click();
        checkButton.isSelected();

    }

    public void orderBySelector() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(selection).click();
        Thread.sleep(2000);
        driver.findElement(orderByvalue).click();
    }

    public void closeBrowser() {
        driver.quit();
    }
}

