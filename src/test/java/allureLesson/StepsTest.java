/*
package allureLesson;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsTest {
    @DisplayName("Проверка имени задачи через Steps")
    @Test
    void checkName() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();

        steps.openPage("selenide/selenide/issues");
        steps.searchIssueId("2705");
        steps.checkName("2705", "Selenide proxy should allow mocking server response AND specify content type");
    }
}
*/
