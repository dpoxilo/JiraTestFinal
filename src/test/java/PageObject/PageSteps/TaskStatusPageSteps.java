package PageObject.PageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static PageObject.PageElements.TaskStatusPage.*;
import static WebHooks.Hooks.saveAsScreenshot;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TaskStatusPageSteps {
    @Step("ищем созданную задачу")
    public static void clickToFindTask(String task) {
        findTask.shouldBe(visible, Duration.ofSeconds(60)).click();
        findTask.setValue(task).pressEnter();
        saveAsScreenshot();
    }

    @Step("проверяем статус задачи")
    public static void clickToCheckStatus(String status) {
        statusCheck.shouldBe(visible, Duration.ofSeconds(60)).click();
        Assertions.assertEquals(status, statusCheck.getText().toLowerCase(), "Статус задачи не верен!");
        saveAsScreenshot();
    }

    @Step("меняем статус задачи на Готово")
    public static void clickToSetReady() {
        setReady.shouldBe(visible, Duration.ofSeconds(60)).click();
        $x("//span[text()='Выполнено']").click();
        saveAsScreenshot();
    }

    @Step("проверяем новый статус задачи")
    public static void checkFinalStatus(String checkStatus) {
        while (!taskStatusCheck.getText().equals(checkStatus)) {
            taskStatusCheck.getText();
        }
        Assertions.assertEquals(checkStatus, taskStatusCheck.getText(), "Статус задачи не верный!");
        saveAsScreenshot();
    }
}
