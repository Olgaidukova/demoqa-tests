package demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPageObjectsTests extends TestBase {


    @Test
    void fillFormTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmail = "qaguru@qa.guru";
        String gender = "Male";
        String userNumber = "0123456789";
        String birthMonth = "November";
        String birthYear = "2000";
        String birthDay = "6";
        String subject = "Physics";
        String hobby = "Sports";
        String picture = "picture.jpg";
        String address = "Current Address";
        String state = "NCR";
        String city = "Delhi";

        //Actions
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        //Checks
        practiceFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }
}
