package allureLesson;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {

    @Step("Открыть страницу {page}")
    public void openPage (String page) {
        open("https://github.com/" + page);
    }

    @Step("Ввести номер задачи IssueId и выполнить поиск")
    public void searchIssueId (String issueId) {
        $("#js-issues-search").click();
        $("#js-issues-search").setValue(issueId);
        $("#js-issues-search").pressEnter();
    }

    @Step("Заголовок задачи {issueId} соответствует значению {issueName}")
    public void checkName (String issueId, String issueName){
        $("#issue_"+ issueId + "_link").shouldHave(
                text(issueName));
    }
}
