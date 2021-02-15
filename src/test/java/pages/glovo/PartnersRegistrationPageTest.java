package pages.glovo;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static pages.glovo.Commons.BASE_URL_GLOVO;

class PartnersRegistrationPageTest {
    PartnersRegistrationPage page;
    NextRegistrationPage nextRegistrationPage;
    Faker faker = new Faker();

    @BeforeEach
    public void acceptCookies() {
        page = open( BASE_URL_GLOVO + "/Partners", PartnersRegistrationPage.class );
        page.acceptCookies();
    }

    @Test
    public void PartnersRegistrationPage() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String tel = faker.phoneNumber().phoneNumber();
        String numberBranches = faker.numerify( "1" );

        // dropdown country
        page.selectDropdownCountry( "France" );

        page.fillName( firstName );
        page.fillLastName( lastName );
        page.fillEmail( email );

        // dropdown code tel number
        page.selectDropdownCodeCountryTel( "+93" );

        page.fillTelInput( tel );

        // dropdown type of business

        page.selectDropdownType( "Restaurant" );


        page.fillNumberBranches( numberBranches );
        page.fillCheckBox();
        page.clickNextButton().getPageTitle().should( exist );
    }
}
