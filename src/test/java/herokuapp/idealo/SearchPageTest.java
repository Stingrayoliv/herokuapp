package herokuapp.idealo;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.idealo.SearchPage;

import static com.codeborne.selenide.Selenide.open;

import static pages.Commons.BASE_URL;

public class SearchPageTest {
    SearchPage searchPage = open( BASE_URL, SearchPage.class );

    @BeforeTest
    public void acceptCookies() {
        searchPage.acceptCookies();
    }


    @Test
    public void makeSearch() {
        searchPage.makeSearch( "E-bikes" );
        searchPage.selectPrice("Höchster zuerst");
        searchPage.receiveHighestPrice().shouldHave( Condition.attribute( " value selected", "selected" ) );

    }
}
