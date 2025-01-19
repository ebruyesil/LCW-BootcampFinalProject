package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        try {
            WebElement cookieRejectButton = driver.findElement(By.xpath("//button[contains(text(), 'Reddet')]"));
            if (cookieRejectButton.isDisplayed()) {
                cookieRejectButton.click();
                }
            } catch (Exception _) {
                }

        hoverOverElement(By.id("user_1_"));

        clickElement(By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']"));

        Assertions.assertEquals("Üye Girişi | LCW", driver.getTitle());

        new LoginPage(driver);
    }
}
