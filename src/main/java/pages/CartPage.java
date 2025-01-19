package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {super(driver);}

    public void verifyCartDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String actualName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='rd-cart-item-code']"))).getText();
        assert actualName.equals("Mont") || actualName.equals("Kaban") : "Ürün adı doğrulanamadı.";

        String actualColor = driver.findElement(By.xpath("//span[@class='rd-cart-item-color']")).getText();
        assert actualColor.equals("Renk: Koyu Bej") || actualColor.equals("Renk: Bej"): "Ürün rengi doğrulanamadı.";

        int actualQuantity = Integer.parseInt(driver.findElement(By.xpath("//input[contains(@class, 'quantity-input')]")).getAttribute("value"));

        assert actualQuantity == 1 : "Ürün adedi doğrulanamadı.";

    }
    @Step("Ürün miktarı bir arttırılır ve fiyat bilgisi doğrulanır.")
    public void updateQuantityAndVerifyPrice() throws InterruptedException {
        verifyCartDetails();

        WebElement incrementButton = driver.findElement(By.xpath("//a[contains(@id, 'Cart_AddQuantity')]"));
        clickUsingJS(incrementButton);

        Thread.sleep(4000);
        String productTotal = driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']")).getText();
        String paymentTotal = driver.findElement(By.xpath("//div[@class='price-info-area']//span[@class='total-grand-box-amount']")).getText();
        assert productTotal.equals(paymentTotal) : "Tutarlar eşleşmiyor!";
    }

    @Step("Ürün favorilere eklenir.")
    public void addToFavorites() throws InterruptedException {
        clickElement(By.xpath("//i[@class='fa fa-heart-o']"));
        Thread.sleep(1000);
    }
}