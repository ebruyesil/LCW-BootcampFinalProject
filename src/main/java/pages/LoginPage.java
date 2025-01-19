package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("E-posta girilir.")
    public void enterEmail(String email) {
        sendKeys(By.xpath("//input[@placeholder='E-posta Adresi veya Telefon Numarası']"), email);
        clickElement(By.xpath("//button[normalize-space()='Devam Et']"));
    }

    @Step("Şifre girilir.")
    public void enterPassword(String password) {
        sendKeys(By.xpath("//input[@placeholder='Şifreniz']"), password);
        clickElement(By.xpath("//button[@type='submit']"));
        driver.navigate().to("https://www.lcw.com/");
    }
}
