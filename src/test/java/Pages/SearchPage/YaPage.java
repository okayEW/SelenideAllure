package Pages.SearchPage;

import Pages.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class YaPage extends BasePage {

    @Override
    public SelenideElement pageLoaderVeriferElement() {
        return searchInput;
    }
    private final SelenideElement searchInput = $(By.id("text"));
    private final SelenideElement searchButton = $x("//button[@type='submit']");
    public YaPage(String url){
        Selenide.open(url);
    }

    public YaPage ClickOnSearchInput(){
        ClickOnVisibleElement(searchInput);
        return this;
    }
    public YaPage SendKeysToSearchInput(String text){
            SendKeys(searchInput, text);
            return this;
    }
    public void ClickOnSearchButton(){
            ClickOnVisibleElement(searchButton);
    }
}