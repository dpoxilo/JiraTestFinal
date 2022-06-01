package PageObject.PageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static PageObject.PageElements.LoginPage.*;
import static WebHooks.Hooks.saveAsScreenshot;
import static com.codeborne.selenide.Condition.visible;

public class LoginPageSteps {
    @Step("вводим логин")
    public static void loginVal(String name) {
        loginJira.shouldBe(visible, Duration.ofSeconds(60)).click();
        loginJira.setValue(name);
        saveAsScreenshot();
    }

    @Step("вводим пароль")
    public static void passwordVal(String pass) {
        passwordJira.shouldBe(visible, Duration.ofSeconds(60)).click();
        passwordJira.setValue(pass);
        saveAsScreenshot();
    }

    @Step("нажимаем кнопку Войти")
    public static void clickButtonLogIn() {
        buttonLogIn.shouldBe(visible, Duration.ofSeconds(60)).click();
        saveAsScreenshot();
    }

    @Step("проверяем авторизацию")
    public static void authorizeAssertion(String authorize) {
        inProfile.shouldBe(visible, Duration.ofSeconds(60)).click();
        viewProfile.shouldBe(visible, Duration.ofSeconds(60)).click();
        Assertions.assertEquals(authorize, getUserName.getText(), "Пользователь не авторизован!");
        saveAsScreenshot();
    }

    @Step("выходим из профиля")
    public static void outLog(){
        inProfile.shouldBe(visible, Duration.ofSeconds(60)).click();
        logOut.shouldBe(visible, Duration.ofSeconds(60)).click();
        saveAsScreenshot();
    }
}
