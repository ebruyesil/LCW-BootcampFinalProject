package tests;


import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Doğru e-posta ve şifre ile kullanıcının başarılı bir şekilde giriş yapması test edilir.")
    public void testLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToLoginPage();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
}
