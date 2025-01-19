package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FavoritePage extends BasePage {

    public FavoritePage(WebDriver driver) {super(driver);}


    @Step("Favoriler sayfasına gidilir ve favorilere eklenen ürünün doğru şekilde listelendiği doğrulanır.")
    public void goToFavoritesPage(String expectedProductName) {
        clickElement(By.xpath("//span[normalize-space()='Favorilerim']"));
        scrollPage(250);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement favoriteProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'product-card__title')]")));
        assertTrue(expectedProductName.contains(favoriteProduct.getText()), "Favorilere eklenen ürün doğru şekilde listelenmedi.");

        driver.navigate().back();
        clickElement(By.xpath("//div[@class='col-md-12 pl-20 pr-20']//a[@class='main-button mt-15'][normalize-space()='ÖDEME ADIMINA GEÇ']"));
    }
}
