package tests;

import org.testng.annotations.Test;
import pages.*;

public class CartTest extends BaseTest {

    @Test(description = "Sepetteki ürün detayları doğrulanır, miktar güncellemesi yapılarak fiyatlar kontrol edilir ve ürün favorilere eklenir.")
    public void testCart() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        FilterPage filterPage = new FilterPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.goToLoginPage();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        driver.navigate().to(baseURL);

        categoryPage.navigateToCategory(mainCategory, subCategory, productCategory);

        filterPage.apply6AgeFilter();
        Thread.sleep(2000);
        filterPage.applyAgeFilters(ages);
        filterPage.applyColorFilter(color);
        Thread.sleep(2000);
        filterPage.selectSortOption(option);
        filterPage.clickProduct(index);

        productDetailPage.addAvailableSizeToCart();
        Thread.sleep(2000);
        productDetailPage.goToCart();

        cartPage.updateQuantityAndVerifyPrice();
        cartPage.addToFavorites();

    }
}
