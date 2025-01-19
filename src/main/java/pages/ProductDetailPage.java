package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    
    @Step("Mevcut bedenlerden rastgele biri seçilip sepete eklenir.")
    public void addAvailableSizeToCart() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'option-size-box') and not(contains(@class, 'out-of-stock'))]")));

            List<WebElement> availableSizes = driver.findElements(By.xpath("//button[contains(@class, 'option-size-box') and not(contains(@class, 'out-of-stock'))]"));

            if (availableSizes.isEmpty()) {
                throw new RuntimeException("Tükenmemis beden bulunamadi!");
            }

            Random random = new Random();
            clickUsingJS(availableSizes.get(random.nextInt(availableSizes.size())));
            availableSizes.get(random.nextInt(availableSizes.size())).click();

        } catch (Exception _) {
        }
        Thread.sleep(2000);

        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='SEPETE EKLE']")));

        clickUsingJS(cartButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Sepetim']")));

    }

    @Step("Ürün adı alınır.")
    public String getProductName() {
        WebElement productNameElement = driver.findElement(By.xpath("//h1[@class='product-title']"));
        return productNameElement.getText();
    }

    @Step("Sepetim sayfasına gidilir.")
    public void goToCart() {
        WebElement cartIcon = driver.findElement(By.xpath("//span[normalize-space()='Sepetim']"));
        clickUsingJS(cartIcon);
    }

}
