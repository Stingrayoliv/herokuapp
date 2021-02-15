package pages.glovo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class NextRegistrationPage {

    @FindBy(className = "title")
    private SelenideElement pageTitle;

    public SelenideElement getPageTitle() {
        return pageTitle;
    }
}
