package pages.idealo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    @FindBy(name = "message-component message-button no-children btn-accept-al")
    private SelenideElement cookies;

    public void acceptCookies() {
        cookies.click();
    }

    @FindBy(id = "i-search-input")
    private SelenideElement inputSearch;

    @FindBy(className = "sortBox-formSelect")
    private SelenideElement dropdownPriceFilter;

    @FindBy(name = "maxPrice")
    private SelenideElement selectedHighestPrice;

    public void makeSearch(String value) {
        inputSearch.setValue( value );
        inputSearch.sendKeys( Keys.ENTER );
    }

    public void selectPrice(String priceFilter) {
        dropdownPriceFilter.selectOption( priceFilter );
    }

    public SelenideElement receiveHighestPrice(){
        return selectedHighestPrice;
    }
}
