package tests;

import org.testng.annotations.Test;
import pages.*;

public class ProductDetailTest extends BaseTest {

    @Test(description = "ürün detay sayfasından rastgele mevcut bir beden seçilip sepete eklenmesi ve sepete gidilmesi test edilir.")
    public void testProductDetails() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        FilterPage filterPage = new FilterPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);

        homePage.goToLoginPage();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

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

    }
}
