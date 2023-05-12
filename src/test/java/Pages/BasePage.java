package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static Entities.Constants.TimeoutVariables.IMPLICIT_WAIT;

public abstract class BasePage {

    public abstract SelenideElement pageLoaderVeriferElement();
    protected static Logger logger = LoggerFactory.getLogger(BasePage.class);

    public void Open(String url){
        try {
            Selenide.open(url);
            logger.debug("Происходит переход по ссылке:\t" + url);
        } catch (Exception e){
            throw new NoSuchElementException("Не удалось переейти по URL:\t" + url, e);
        }
    }
    public void SendKeys(SelenideElement element, String text){
        try {
            element.should(Condition.visible, Duration.ofSeconds(IMPLICIT_WAIT)).sendKeys(text);
            logger.debug("Происходит отправка текста:\t" + text + "\tВ элемент:\t" + element);
        } catch (Exception e){
            throw new NoSuchElementException("Не удалось отправить текст:\t" + text + "\t В элемент:\t" + element, e);
        }
    }
    public void ClickOnVisibleElement(SelenideElement element){
        try {
            element.should(Condition.visible, Duration.ofSeconds(IMPLICIT_WAIT)).click();
            logger.debug("Происходит нажатие по видимому элементу:\t" + element);
        } catch (Exception e) {
            throw new NoSuchElementException("Не удалось нажать по видимому элементу:\t" + element, e);
        }
    }

    /*
    Проверка, что необходимая страница открыта с помощью элемента на этой странице
     */
    public void PageIsOpen(){
        try {
            pageLoaderVeriferElement().shouldBe(Condition.exist);
            logger.debug("Проверка, что элемент подтверждаюший открытие страницы существует\t" + pageLoaderVeriferElement());
        } catch (Exception e) {
            throw new NoSuchElementException("Не удалось обнаружить элемент подтверждаюший открытие страницы:\t" + pageLoaderVeriferElement(), e);
        }
    }
}