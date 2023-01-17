package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesChoice = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateAndCityChoice = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value){
        gender.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setNumber(String value){
        numberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setBirthDate (String birthDay, String birthMonth, String birthYear){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(birthDay, birthMonth, birthYear);

        return this;
    }

    public PracticeFormPage setSubjects(String value){
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String value){
        userHobbiesChoice.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setPicture(String fileName){
        pictureUpload.uploadFile(new File("src/test/resources/" + fileName));
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value){
        stateDropdown.click();
        stateAndCityChoice.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value){
        cityDropdown.click();
        stateAndCityChoice.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage submit(){
        submitButton.click();
        return this;
    }


    public PracticeFormPage verifyResultsModalAppears(){
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public PracticeFormPage verifyResult(String key,String value){
        registrationResultsModal.verifyResult(key,value);

        return this;
    }
}
