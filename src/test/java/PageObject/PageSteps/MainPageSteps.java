package PageObject.PageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static PageObject.PageElements.MainPage.*;
import static WebHooks.Hooks.saveAsScreenshot;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MainPageSteps {
    @Step("открываем список проектов")
    public static void clickToBrowse() {
        browseLink.shouldBe(visible, Duration.ofSeconds(60)).click();
        saveAsScreenshot();
    }

    @Step("выбираем главный проект")
    public static void clickToMainProj() {
        mainProj.shouldBe(visible, Duration.ofSeconds(60)).click();
        saveAsScreenshot();
    }

    @Step("открываем список всех задач")
    public static void clickToAllTasks() {
        allTasks.shouldBe(visible, Duration.ofSeconds(60)).click();
        saveAsScreenshot();
    }

    @Step("проверяем отображение списка всех задач")
    public static void findTotalNumberOfTasks() {
        findText.shouldHave(text("1"));
        Assertions.assertTrue(findText.isDisplayed(), "Не отображается список всех задач!");
        saveAsScreenshot();
    }

    @Step("ищем задачу TestSelenium")
    public static void findTaskTestSelenium(String task) {
        enterTextElement.shouldBe(visible, Duration.ofSeconds(60)).click();
        enterTextElement.setValue(task).pressEnter();
        saveAsScreenshot();
    }

    @Step("проверяем статус задачи")
    public static void checkingStatus(String statusTestValue) {
        Assertions.assertEquals(statusTestValue, statusTest.getText().toLowerCase(), "Статус задачи не верен");
        saveAsScreenshot();
    }

    @Step("проверяем версию задачи")
    public static void checkingVersion(String versionTestValue) {
        Assertions.assertEquals(versionTestValue, versTest.getText().toLowerCase(), "Неправильная привязка версии");
        saveAsScreenshot();
    }
}
