package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SolutionTest {
    @Test
    void solutionTest() {
        //открыть github.com
        open("https://github.com");

        //выберите меню Solutions -> Enterprize с помощью команды hover для Solutions
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();

        //Убедитесь что загрузилась нужная страница (To build, scale, and deliver secure software.."
        $(".application-main").shouldHave(text("To build, scale, and deliver secure software."));

    }
}
