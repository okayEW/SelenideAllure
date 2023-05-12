package Tests.TestsGroups.SearchGroup;

import Pages.ResultPage.ResultPage;
import Pages.SearchPage.YaPage;
import Tests.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Entities.Constants.Urls.SEARCH_URL;

public class SearchGroup extends BaseTest {
    @Test
    @DisplayName("Test 1")
    @Description("Test 2")
    public void Search(){
        YaPage yaPage = new YaPage(SEARCH_URL);
        ResultPage resultPage = new ResultPage();

        yaPage
                .SendKeysToSearchInput("Котики")
                .ClickOnSearchButton();

        resultPage.PageIsOpen();

    }
}