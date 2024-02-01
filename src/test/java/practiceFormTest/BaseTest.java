package practiceFormTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.AppConfig;
import helper.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    Attachments attachments = new Attachments();
    AppConfig appConfig = ConfigFactory.create(AppConfig.class, System.getProperties());

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = appConfig.base_url();
        Configuration.browser = appConfig.browser();
        Configuration.browserSize = appConfig.browser_size();
        Configuration.browserVersion = appConfig.browser_version();
        Configuration.holdBrowserOpen = appConfig.is_hold_browser_open();
        Configuration.timeout = appConfig.timeout();
        Configuration.pageLoadTimeout = appConfig.pageLoadTimeout();
    }

    @AfterEach
    public void addAttachments() {
        attachments.takeScreenshot();
        attachments.pageSource();
        attachments.browserConsoleLogs();
    }

}
