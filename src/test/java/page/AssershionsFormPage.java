package page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AssershionsFormPage {
    public SelenideElement registrationVerificationForm(String text) {
        return $x("//td[contains(text(),'"+text+"')]/..");
    }

    public SelenideElement registrationVerificationTitle() {
        return $(".modal-header");
    }
}
