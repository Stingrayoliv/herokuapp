package pages.glovo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class NextRegistrationPage {

    @FindBy(xpath = "//section[@class='principal local']/div[@class='wrapper']/p[@class='title']")
    private SelenideElement text;

    public SelenideElement getText() {
        return text;
    }
}
