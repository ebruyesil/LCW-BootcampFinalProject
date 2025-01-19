package tests;

import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.FilterPage;
import pages.HomePage;
import pages.LoginPage;


public class FilterTest extends BaseTest {

    @Test(description = "Yaş, renk ve sıralama filtrelerinin doğru şekilde uygulandığı ve ürünün tıklanabildiği test edilir.")
    public void testFilter() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        FilterPage filterPage = new FilterPage(driver);

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

    }

}

