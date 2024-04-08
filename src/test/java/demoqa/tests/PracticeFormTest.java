package demoqa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase
{
    @Test
    @Tag("form")
    void practiceFormTest () {

        registrationPage.openPage()
                        .setFirstName(testData.firstName)
                        .setLastName(testData.lastName)
                        .setGender(testData.gender)
                        .setEmail(testData.email)
                        .setNumber(testData.number)
                        .setBirthDate(testData.month, testData.year, testData.day)
                        .setSubject(testData.subject)
                        .setHobbies(testData.hobbies)
                        .uploadPicture(testData.pictureName)
                        .setAddress(testData.address)
                        .setState(testData.state)
                        .setCity(testData.city)
                        .submitForm();

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
    }
}
