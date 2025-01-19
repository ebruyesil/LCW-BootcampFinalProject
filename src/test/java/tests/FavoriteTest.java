package tests;


import org.testng.annotations.Test;
import pages.*;


public class FavoriteTest extends BaseTest {

    @Test(description = "Sepetteki ürün favorilere eklenir ve favoriler sayfasında doğru şekilde listelenip listelenmediği test edilir.")
    public void testAddToFavoritesAndVerify() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        FilterPage filterPage = new FilterPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        CartPage cartPage = new CartPage(driver);
        FavoritePage favoritePage = new FavoritePage(driver);

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
        String productName = productDetailPage.getProductName();
        productDetailPage.goToCart();

        cartPage.updateQuantityAndVerifyPrice();
        cartPage.addToFavorites();
        Thread.sleep(2000);

        favoritePage.goToFavoritesPage(productName);

        Thread.sleep(2000);
    }
}
