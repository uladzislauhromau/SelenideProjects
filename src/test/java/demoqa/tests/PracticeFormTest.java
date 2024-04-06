package demoqa.tests;

import org.junit.jupiter.api.Test;
public class PracticeFormTest extends TestBase
{

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

        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setGender(gender)
                        .setEmail(email)
                        .setNumber(number)
                        .setBirthDate(month, year, day)
                        .setSubject(subject)
                        .setHobbies(hobbies)
                        .uploadPicture(pictureName)
                        .setAddress(address)
                        .setState(state)
                        .setCity(city)
                        .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", number)
                .verifyResults("Date of Birth", day + " " + month + "," + year)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", pictureName)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);
    }
}
