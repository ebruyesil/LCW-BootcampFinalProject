package tests;

import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends BaseTest {

    @Test(description = "Kullanıcı giriş yaptıktan sonra istenilen kategoriye navigasyon yapılarak, sayfanın doğru başlıkla yüklendiği test edilir.")
    public void testCategory() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        homePage.goToLoginPage();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        categoryPage.navigateToCategory(mainCategory, subCategory, productCategory);
    }
}
