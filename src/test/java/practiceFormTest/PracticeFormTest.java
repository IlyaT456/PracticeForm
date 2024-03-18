package practiceFormTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import step.FormSteps;


public class PracticeFormTest extends BaseTest {
    FormSteps formSteps = new FormSteps();
    @Test
    @DisplayName("Проверка регистрации формы demoqa.com")
    public void testChekingRegistrationFormDemoQA() {
        formSteps.openFormRegistration()
                .setFullFormaRegistr()
                .verificationSuccessfulRegistrationForm();
    }
}
