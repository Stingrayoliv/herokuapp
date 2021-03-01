package pages.idealo;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private static final By BODY= By.cssSelector( "body" );
    private static final By OK_BTN=By.cssSelector( ".btn-accept-all" );

    @FindBy(css = "body > div > iframe")
    private SelenideElement iframe;


    public void acceptCookies() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebElement frame = driver.switchTo().frame( iframe ).findElement(BODY );
        frame.findElement( OK_BTN ).click();
        driver.switchTo().parentFrame();
    }

    @FindBy(id = "i-search-input")
    private SelenideElement inputSearch;



    public ProductCategoryPage makeSearch(String value) {
        inputSearch.setValue( value );
        inputSearch.sendKeys( Keys.ENTER );
        return page(ProductCategoryPage.class);
    }

}
