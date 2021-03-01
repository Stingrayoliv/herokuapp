package pages.idealo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProductCategoryPage {

    @FindBy(css = ".sortBox-formSelect")
    private SelenideElement dropdownPriceFilter;

    @FindBy(xpath = "//option[@value='maxPrice']")
    private SelenideElement selectedHighestPrice;

    public void selectPrice(String priceFilter) {
        dropdownPriceFilter.selectOption( priceFilter );
    }

    public SelenideElement receiveHighestPrice() {
        return selectedHighestPrice;
    }
}
