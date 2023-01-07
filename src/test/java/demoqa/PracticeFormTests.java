package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

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
        File picture = new File ("src/test/resources/picture.jpg");
        String address = "Current Address";
        String state = "NCR";
        String city = "Delhi";

        //Actions
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__month").$(byText(birthDay)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFile(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $(byText("Submit")).click();

        //Checks
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("tbody").shouldHave(text(firstName + " " + lastName));
        $("tbody").shouldHave(text(userEmail));
        $("tbody").shouldHave(text(gender));
        $("tbody").shouldHave(text(userNumber));
        $("tbody").shouldHave(text(birthDay + " " + birthMonth + "," + birthYear));
        $("tbody").shouldHave(text(subject));
        $("tbody").shouldHave(text(hobby));
        $("tbody").shouldHave(text(address));
        $("tbody").shouldHave(text(state + " " + city));
    }
}
