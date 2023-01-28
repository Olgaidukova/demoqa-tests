package demoqa;


import org.junit.jupiter.api.Test;

public class PracticeFormWithJavaFakerTests extends TestBase {


    @Test
    void fillFormTest() {
        TestData data = new TestData();

        //Actions
        practiceFormPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender(data.gender)
                .setNumber(data.userNumber)
                .setBirthDate(data.birthDay, data.birthMonth, data.birthYear)
                .setSubjects(data.subject)
                .setHobbies(data.hobby)
                .setPicture(data.picture)
                .setCurrentAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .submit();

        //Checks
        practiceFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Gender", data.gender)
                .verifyResult("Mobile", data.userNumber)
                .verifyResult("Date of Birth", data.birthDay + " " + data.birthMonth + "," + data.birthYear)
                .verifyResult("Subjects", data.subject)
                .verifyResult("Hobbies", data.hobby)
                .verifyResult("Address", data.address)
                .verifyResult("State and City", data.state + " " + data.city);
    }
}
