package Pages.ResultPage;

import Pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ResultPage extends BasePage {


    @Override
    public SelenideElement pageLoaderVeriferElement() {
        return imageBox;
    }
    private final SelenideElement imageBox = $x("//li[@class='serp-item serp-item_card']");
}