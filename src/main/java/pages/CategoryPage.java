package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

        @Step("İstenilen kategoriye navigasyon yapılır.")
        public void navigateToCategory(String mainCategory, String subCategory, String productCategory) {
        hoverOverElement(By.xpath("//a[normalize-space()='" + mainCategory + "']"));
        hoverOverElement(By.xpath("//span[normalize-space()='" + subCategory + "']"));
        clickElement(By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='" + productCategory + "']"));
        Assertions.assertEquals("Kız Çocuk Dış Giyim Fiyatları ve Modelleri | LCW", driver.getTitle());
    }
}
