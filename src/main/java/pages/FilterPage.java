package pages;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage extends BasePage {

    public FilterPage(WebDriver driver) {super(driver);}

    @Step("Sayfa yüklendikten sonra ürünlerin görünürlüğü kontrol edilir.")
    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-item']")));
            } catch (TimeoutException _) {
                }
    }

    @Step("Yaş filtreleri uygulanır.")
    public void applyAgeFilters(String... ages) {
        scrollPage(1000);

        for (String age : ages) {
            WebElement ageFilter = driver.findElement(By.xpath("//span[contains(text(),'" + age + "')]"));
            if (!ageFilter.isSelected()) {
                clickUsingJS(ageFilter);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException _) {
                }
            }
        }
    }
    @Step("6 Yaş filtresi uygulanır.")
    public void apply6AgeFilter() {
        scrollPage(1000);

        WebElement ageFilter = driver.findElement(By.xpath("//body/div[@id='root']/div[@class='page-wrapper']/div[@class='product-list-container']/div[@class='product-list']/div[@class='container-fluid']/div[@class='product-list__content-area']/div[@class='desktop-filter-area desktop-filter-area--fixed']/div[@class='desktop-filter-area__content']/div[@class='filter']/div[@class='collapsible-filter-container']/div[@class='collapsible-filter-container__body']/div[@class='collapsible-filter-container__content-area collapsible-filter-container__content-area--size-filter']/div[3]/span[1]"));
        if (!ageFilter.isSelected()) {
            clickUsingJS(ageFilter);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException _) {
            }
        }
    }

    @Step("Renk filtresi uygulanır.")
    public void applyColorFilter(String color) {
        scrollPage(1000);

        WebElement colorFilter = driver.findElement(By.xpath("//span[normalize-space()='" + color + "']"));
        clickUsingJS(colorFilter);
    }

    @Step("Sıralama seçeneği seçilir.")
    public void selectSortOption(String option) {
        scrollPage(0);

        WebElement dropdownButton = driver.findElement(By.xpath("//button[@class='dropdown-button__button']"));
        clickUsingJS(dropdownButton);

        WebElement sortOption = driver.findElement(By.xpath("//a[normalize-space()='" + option + "']"));
        clickUsingJS(sortOption);
    }

    @Step("İstenilen indexteki ürüne tıklanır.")
    public void clickProduct(int index) {
        waitForPageToLoad();
        Assertions.assertEquals("https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010?beden=6-yas,5-6-yas,6-7-yas&renk=bej&siralama=en-cok-satanlar", driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[6]/div/div[2]/div[" + index + "]")).click();
    }
}

