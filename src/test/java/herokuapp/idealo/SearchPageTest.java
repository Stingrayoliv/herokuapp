package herokuapp.idealo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.idealo.ProductCategoryPage;
import pages.idealo.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static pages.idealo.Commons.BASE_URL_1;


public class SearchPageTest {
    SearchPage searchPage ;
    ProductCategoryPage productCategoryPage;

    @BeforeTest
    public void acceptCookies() {
        searchPage= open( BASE_URL_1, SearchPage.class );
        WebDriverRunner.getWebDriver().manage().window().maximize();

        searchPage.acceptCookies();
    }


    @Test
    public void makeSearch() {
        productCategoryPage=searchPage.makeSearch( "E-bikes" );
        productCategoryPage.selectPrice("Preis: Höchster zuerst");
        productCategoryPage.receiveHighestPrice().shouldHave( Condition.attribute( "selected", "selected" ) );

    }
}
