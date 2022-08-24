import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestSelenide {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1366x768";
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Проверка того, что на странице SoftAssertions есть пример кода для JUnit5")
    @Test
    public void findPageInGitHubWithCode(){
        Selenide.open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").val("SoftAssertions").pressEnter();
        $(".wiki-pages-box").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4")
                .shouldHave(text("3. Using JUnit5 extend test class:"));
    }

}