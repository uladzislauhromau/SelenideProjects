package demoqa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class PracticeFormTest extends TestBase
{
    @Test
    @Tag("form")
    void practiceFormTest () {

        step("Open form", () ->{
            registrationPage.openPage();
        });

        step("Form filling", () ->{
            registrationPage.setFirstName(testData.firstName);
            registrationPage.setLastName(testData.lastName);
            registrationPage.setGender(testData.gender);
            registrationPage.setEmail(testData.email);
            registrationPage.setNumber(testData.number);
            registrationPage.setBirthDate(testData.month, testData.year, testData.day);
            registrationPage.setSubject(testData.subject);
            registrationPage.setHobbies(testData.hobbies);
            registrationPage.uploadPicture(testData.pictureName);
            registrationPage.setAddress(testData.address);
            registrationPage.setState(testData.state);
            registrationPage.setCity(testData.city);
            registrationPage.submitForm();
        });

        step("Verify form", () ->{
            registrationPage.verifyResultsModalAppears()
                    .verifyResults("Student Name", testData.firstName + " " + testData.lastName)
                    .verifyResults("Student Email", testData.email)
                    .verifyResults("Gender", testData.gender)
                    .verifyResults("Mobile", testData.number)
                    .verifyResults("Date of Birth", testData.dateBirth)
                    .verifyResults("Subjects", testData.subject)
                    .verifyResults("Hobbies", testData.hobbies)
                    .verifyResults("Picture", testData.pictureName)
                    .verifyResults("Address", testData.address)
                    .verifyResults("State and City", testData.state + " " + testData.city);
        });
    }
}
