package allureLesson;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class LambdaTest {
    @DisplayName("Проверка через Lambda")
    @Test
    void checkNameLambda () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу с задачами", () -> {
            open("https://github.com/selenide/selenide/issues");
        });

        step("Ввести номер задачи '2705' и выполнить поиск", () -> {
            $("#js-issues-search").click();
            $("#js-issues-search").setValue("2705");
            $("#js-issues-search").pressEnter();
        });

        step("Заголовок задачи 2705 соответствует значению Selenide proxy should allow mocking server response AND specify content type", () -> {
            $("#issue_2705_link").shouldHave(
                    text("Selenide proxy should allow mocking server response AND specify content type"));
        });
    }
}
