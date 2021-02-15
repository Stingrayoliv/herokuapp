package pages.glovo;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static pages.glovo.Commons.BASE_URL_GLOVO;

class PartnersRegistrationPageTest {
    PartnersRegistrationPage page;
    NextRegistrationPage nextRegistrationPage;
    Faker faker=new Faker();

    @BeforeEach
    public void acceptCookies(){
        page=open(BASE_URL_GLOVO+"/Partners", PartnersRegistrationPage.class);
        page.acceptCookies();
    }

    @Test
    public void PartnersRegistrationPage(){
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.internet().emailAddress();
        PhoneNumber tel=faker.phoneNumber();
        String numberBranches=faker.numerify( "1" );

        // dropdown country
        page.selectDropdownCountry("Франция");
        page.selectCountry().shouldHave( text("Франция") );

        page.fillName( firstName );
        page.fillLastName( lastName );
        page.fillEmail( email );

        // dropdown code tel number
        page.selectDropdownCodeCountryTel("+93");
        page.getSelectedCodeCountry().shouldHave(text("+93")  );

        page.fillTelInput(tel);

        // dropdown type of business
        page.selectDropdownType("Pecторан"); //
        page.getType().shouldHave( text("Pecторан") );


        page.fillNumberBranches( numberBranches );
        page.fillCheckBox();
        page.getNextPage();
        page.getNextPage().getText().shouldHave( text("Нам нужна более подробная информация ") );




    }

}