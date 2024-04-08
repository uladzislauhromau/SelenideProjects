package allureLesson;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @DisplayName("Чистый Selenide")
    @Test
    void checkName() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/selenide/selenide/issues");
        $("#js-issues-search").click();
        $("#js-issues-search").setValue("2705");
        $("#js-issues-search").pressEnter();
        $("#issue_2705_link").shouldHave(
                text("Selenide proxy should allow mocking server response AND specify content type"));
    }
}
