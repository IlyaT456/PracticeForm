package step;


import com.codeborne.selenide.Condition;
import com.google.common.collect.ImmutableMap;
import data.FakerData;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import page.AssershionsFormPage;
import page.FormPage;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormSteps extends FakerData {

    FormPage formPages = new FormPage();
    private final String URL = "/automation-practice-form";
    private final String execution = "Thanks for submitting the form";
    private final String studentName = firstName + " " + lastName;
    private final String stateAndCity = state + " " + city;


    Map<String, String> checkForm = ImmutableMap.of(
            "Student Name", studentName,
            "Student Email", userEmail,
            "Gender", gender,
            "Mobile", phoneNumber,
            "Subjects", subject,
            "Hobbies", hobbies,
            "Picture", picture,
            "Address", currentAddress,
            "State and City", stateAndCity);
    AssershionsFormPage assershionsForm = new AssershionsFormPage();

    @Step("Открываем форму регистрации")
    public FormSteps openFormRegistration() {
        open(URL);
        return this;
    }

    @Step("Заполняем поле 'firstName'")
    public FormSteps setFirstName(String firstName) {
        formPages.firstName().setValue(firstName);
        return this;
    }

    @Step("Заполняем поле 'lastName'")
    public FormSteps setLastName(String lastName) {
        formPages.lastName().setValue(lastName);
        return this;
    }

    @Step("Заполняем поле 'userEmail'")
    public FormSteps setUserEmail(String userEmail) {
        formPages.userEmail().setValue(userEmail);
        return this;
    }

    @Step("Заполняем поле 'gender'")
    public FormSteps setGender(String gender) {
        formPages.gender(gender).click();
        return this;
    }

    @Step("Заполняем поле 'userNumber'")
    public FormSteps setUserNumber(String userNumber) {
        formPages.userNumber().setValue(userNumber);
        return this;
    }

    @Step("Заполняем поле 'subjects'")
    public FormSteps setSubjects(String subjects) {
        formPages.inputSubjects().setValue(subjects).pressEnter();
        return this;
    }

    @Step("Заполняем поле 'hobbies'")
    public FormSteps setHobbies(String hobbies) {
        formPages.hobbies(hobbies).click();
        return this;
    }

    @Step("Заполняем поле 'picture'")
    public FormSteps setPicture(String picture) {
        formPages.picture().uploadFromClasspath(picture);
        return this;
    }

    @Step("Заполняем поле 'Current Address'")
    public FormSteps setCurrentAddress(String address) {
        formPages.currentAddress().setValue(address);
        return this;
    }


    @Step("Заполняем поле 'State and City'")
    public FormSteps setStateAndCity() {
        formPages.dropDownMenuState().click();
        formPages.internalMenuState().setValue(state).pressEnter();
        formPages.dropDownMenuCity().click();
        formPages.internalMenuCity().setValue(city).pressEnter();
        return this;
    }

    @Step("Заполняем поле 'Date Of Birth day'")
    public FormSteps setDateOfBirthday() {
        formPages.dateOfBirth().click();
        formPages.month().selectOption(monthOfBirth);
        formPages.year().selectOption(yearOfBirth);
        formPages.day(dayOfBirth).click();
        return this;
    }

    @Step("Нажатие на кнопку регистрации")
    public FormSteps сlickinRegistrationButton() {
        formPages.buttonRegistratoin().scrollTo().click();
        return this;
    }

    @Step("Заполнение формы регистрации demoqa.com")
    public FormSteps setFullFormaRegistr() {
        setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(phoneNumber)
                .setDateOfBirthday()
                .setSubjects(subject)
                .setGender(gender)
                .setHobbies(hobbies)
                .setCurrentAddress(currentAddress)
                .setPicture(picture)
                .setStateAndCity()
                .сlickinRegistrationButton();
        return this;
    }

    @Step("Проверка успешной регистрации формы")
    public FormSteps verificationSuccessfulRegistrationForm() {
        assershionsForm.registrationVerificationTitle().should(Condition.text(execution), Duration.ofSeconds(15));
        for (Map.Entry<String, String> entry : checkForm.entrySet()) {
            assertEquals(assershionsForm.registrationVerificationForm(entry.getKey()).getText(), String.format("%s %s", entry.getKey(), entry.getValue()));
        }
        return this;
    }
}
