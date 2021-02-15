package pages.glovo;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class PartnersRegistrationPage {
    @FindBy(id = "onetrust-accept-btn-handler")
    private SelenideElement cookies;

    @FindBy(xpath = "p[@class='dropdown-toggle']")
    private SelenideElement dropdownCountry;

    @FindBy(css = "//span[contains(.,'Франция')]")
    private SelenideElement selectedCountry;

    @FindBy(xpath = "//div[2]/input")
    private SelenideElement firstNameInput;

    @FindBy(xpath = "//div[3]/input")
    private SelenideElement lastNameInput;

    @FindBy(xpath = "//input[@type='email']")
    private SelenideElement emailInput;

    @FindBy(css = ".multiselect__input")
    private SelenideElement dropdownCodeCountryTel;

    @FindBy(xpath = "//span[@class='multiselect__single']")
    private SelenideElement selectedCodeCountry;

    @FindBy(id = "phon")
    private SelenideElement telInput;

    @FindBy(xpath = "//span[class='valor']")
    private SelenideElement dropdownType;

    @FindBy(xpath = "//span[contains(.,'Ресторан')]")
    private SelenideElement typeOption;

    @FindBy(xpath = "//input[@name='numberBranches']")
    private SelenideElement inputNumberBranches;

    @FindBy(xpath = "//form[@id='form-home']/div/div[8]/div/label/span")
    private SelenideElement checkBox;

    @FindBy(xpath = "//button[contains(.,'Продолжить')]")
    private SelenideElement nextButton;

    public  void selectDropdownCountry(String country){
        dropdownCountry.selectOption(country);
    }

    public SelenideElement selectCountry(){
        return selectedCountry;
    }

    public void fillName(String name) {
        firstNameInput.setValue( name );
    }

    public void fillLastName(String lastName) {
        lastNameInput.setValue( lastName );
    }

    public void fillEmail(String email) {
        emailInput.setValue( email );
    }

    public void selectDropdownCodeCountryTel(String codeCountry) {
        selectedCodeCountry.selectOption( codeCountry );
    }

    public SelenideElement getSelectedCodeCountry(){
        return selectedCodeCountry;
    }

    public void fillTelInput(PhoneNumber tel) {
        telInput.setValue( tel.phoneNumber() );
    }

    public void selectDropdownType(String type) {
        dropdownType.selectOption( type );
    }

    public SelenideElement getType(){
        return typeOption;
    }

    public void fillNumberBranches(String number) {
        inputNumberBranches.setValue( number );
    }

    public void fillCheckBox(){
        checkBox.click();
    }

    public NextRegistrationPage getNextPage(){
        nextButton.click();
        return page(NextRegistrationPage.class);
    }

    public void acceptCookies() {
        cookies.click();
    }
}
