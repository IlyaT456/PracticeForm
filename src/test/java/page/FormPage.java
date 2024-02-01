package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class FormPage {
    public SelenideElement firstName() {
        return $("#firstName");
    }

    public SelenideElement lastName() {
        return $("#lastName");
    }

    public SelenideElement userEmail() {
        return $("#userEmail");
    }

    public SelenideElement gender(String gender) {
        return $x("//input[@value='%s']/following-sibling::label".formatted(gender));
    }

    public SelenideElement userNumber() {
        return $("#userNumber");
    }

    public SelenideElement dateOfBirth() {
        return $("#dateOfBirthInput");
    }

    public SelenideElement month() {
        return $x("//select[@class='react-datepicker__month-select']");
    }

    public SelenideElement year() {
        return $x("//select[@class='react-datepicker__year-select']");
    }

    public SelenideElement day(String day) {
        return $x("//div[@class='react-datepicker__month-container']");
    }

    public SelenideElement inputSubjects() {
        return $("#subjectsInput");
    }

    public SelenideElement hobbies(String text) {
        return $x("//label[text()='"+text+"']");
    }

    public SelenideElement picture() {
        return $("#uploadPicture");
    }

    public SelenideElement currentAddress() {
        return $("#currentAddress");
    }

    public SelenideElement internalMenuState() {
        return $("#react-select-3-input");
    }

    public SelenideElement dropDownMenuState() {
        return $("#state");
    }

    public SelenideElement dropDownMenuCity() {
        return $("#city");
    }

    public SelenideElement internalMenuCity() {
        return $("#react-select-4-input");
    }

    public SelenideElement buttonRegistratoin() {
        return $("#submit");
    }
}
