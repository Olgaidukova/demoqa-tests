package demoqa;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PracticeFormWithJavaFakerTests extends TestBase {


    @Test
    @Tag("Jenkins")
    @Owner("Olga Gaidukova")
    @DisplayName("Проверка заполнения формы")
    void fillFormTest() {
        TestData data = new TestData();
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть Practice Form", () -> {
            practiceFormPage.openPage();
        });
        step("Заполнить форму тестовыми данными", () -> {
            practiceFormPage.setFirstName(data.firstName)
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
                    .setCity(data.city);
        });

        step("Нажать кнопку Submit", () -> {
            practiceFormPage.submit();
        });

        //Checks
        step("Проверить данные в итоговой таблице", () -> {
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
        });
    }
}
