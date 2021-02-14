package herokuapp;

import org.junit.jupiter.api.Test;
import pages.herokuapp.SliderPage;

import static pages.herokuapp.Commons.BASE_URL;
import static com.codeborne.selenide.Selenide.open;

public class SliderTest {

    @Test
    public void testSlider() {
        SliderPage sliderPage = open( BASE_URL + "/horizontal_slider", SliderPage.class);
        sliderPage.moveSlider("2");
    }
}
