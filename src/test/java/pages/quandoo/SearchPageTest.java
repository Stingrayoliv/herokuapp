package pages.quandoo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;

class SearchPageTest {
    SearchPage page;

    @BeforeEach
    public void acceptCookies() {
        page = open("https://www.quandoo.de/en/berlin", SearchPage.class);
        page.acceptCookies();
    }

    @Test
    public void topRatedButton() {
        page.clickTopRatedBtn();
        page.topRatedBtnAttribute().shouldHave(attribute("data-state", "active"));
        page.topRatedFilter().should(exist);
    }
}
