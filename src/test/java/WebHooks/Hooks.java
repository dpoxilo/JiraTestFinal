package WebHooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;

public class Hooks {
    @Before
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @After
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }

    @BeforeEach
    public void setupAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @Attachment(value = "screen", type = "image/png")
    public static byte[] saveAsScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
