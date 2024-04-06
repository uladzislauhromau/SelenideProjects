package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest
{

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest () {

        String firstName = "Vladislav";
        String lastName = "Gromov";
        String email = "test@gmail.com";
        String gender = "Male";
        String number = "3753367224";
        String day = "08";
        String month = "February";
        String year = "2000";
        String subject = "English";
        String hobbies = "Sports";
        String pictureName = "testing.jpg";
        String address = "MyAddress";
        String state = "NCR";
        String city = "Noida";

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Practice Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);


        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(number);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--0" + day + " ").click();


        $("#subjectsInput").setValue(subject).pressEnter();

        $("#hobbiesWrapper").$(byText(hobbies)).click();

        $("#uploadPicture").uploadFromClasspath(pictureName);

        $("#currentAddress").setValue(address);

        $("#state").click();
        $(byText(state)).click();

        $("#city").click();
        $(byText(city)).click();

        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

}
