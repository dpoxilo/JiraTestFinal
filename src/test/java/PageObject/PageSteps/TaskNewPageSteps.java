package PageObject.PageSteps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;

import static PageObject.PageElements.TaskNewPage.*;
import static WebHooks.Hooks.saveAsScreenshot;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TaskNewPageSteps {
    @Step("создаем новую задачу")
    public static void clickToCreateNewTask() {
        createNewTask.shouldBe(visible, Duration.ofSeconds(60)).click();
        saveAsScreenshot();
    }

    @Step("выбираем тип задачи")
    public static void setIssueType(String type) {
        issueType.sendKeys(type);
        issueType.pressEnter();
        saveAsScreenshot();
    }

    @Step("заполняем заголовок задачи")
    public static void setErrorTheme(String theme) {
        errorTheme.shouldBe(visible, Duration.ofSeconds(60)).click();
        errorTheme.setValue(theme);
        saveAsScreenshot();
    }

    @Step("заполняем описание задачи")
    public static void setErrInfo(String info) {
        Selenide.switchTo().defaultContent();
        SelenideElement iframe = errorInfo;
        Selenide.switchTo().frame(iframe);
        $x("//body[@id='tinymce']/p").sendKeys(info);
        Selenide.switchTo().defaultContent();
        saveAsScreenshot();
    }

    @Step("выбираем привязку версии")
    public static void setFixInVersions() {
        fixInVersions.doubleClick();
        saveAsScreenshot();
    }

    @Step("выбираем приоритет")
    public static void setPriority(String priority) {
        prior.shouldBe(visible, Duration.ofSeconds(60)).click();
        prior.sendKeys(priority);
        prior.pressEnter();
        saveAsScreenshot();
    }

    @Step("заполняем тэг")
    public static void setHashTag(String tag) {
        hashTag.sendKeys(tag);
        hashTag.pressEnter();
        saveAsScreenshot();
    }

    @Step("заполняем окружение")
    public static void setMoreInfo(String info2) {
        Selenide.switchTo().defaultContent();
        SelenideElement iframe = moreInfo;
        Selenide.switchTo().frame(iframe);
        $x("//body[@id='tinymce']/p").sendKeys(info2);
        Selenide.switchTo().defaultContent();
        saveAsScreenshot();
    }

    @Step("выбираем затронутые версии")
    public static void setVersionsAffected() {
        versionsAffected.shouldBe(visible, Duration.ofSeconds(60)).doubleClick();
        saveAsScreenshot();
    }

    @Step("назначаем задачу на себя")
    public static void clickToAssignMe() {
        assignMe.shouldBe(visible, Duration.ofSeconds(60)).click();
        saveAsScreenshot();
    }

    @Step("нажимаем кнопку Создать")
    public static void clickSubmit() {
        submit.shouldBe(visible, Duration.ofSeconds(60)).click();
        saveAsScreenshot();
    }

    @Step("проверяем создание новой задачи")
    public static void taskNewPageAssertion() {
        Assertions.assertTrue(newTaskAssert.isEnabled(), "Новая задача не создалась!");
        saveAsScreenshot();
    }
}
