import WebHooks.Hooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageObject.PageSteps.LoginPageSteps.*;
import static PageObject.PageSteps.MainPageSteps.*;
import static PageObject.PageSteps.TaskNewPageSteps.*;
import static PageObject.PageSteps.TaskStatusPageSteps.*;
import static Utils.Configuration.getConfigurationValue;
import static com.codeborne.selenide.Selenide.open;

public class RunTest extends Hooks {
    @Test
    @Tag("1")
    @DisplayName("Авторизация")
    public void testLogin() {
        open(getConfigurationValue("url"));
        loginVal(getConfigurationValue("name"));
        passwordVal(getConfigurationValue("pass"));
        clickButtonLogIn();
        authorizeAssertion(getConfigurationValue("name"));
        outLog();
    }

    @Test
    @Tag("2")
    @DisplayName("Проверка общего количества задач и поиск задачи TestSelenium с проверкой статуса, версии")
    public void testMainPage() {
        open(getConfigurationValue("url"));
        loginVal(getConfigurationValue("name"));
        passwordVal(getConfigurationValue("pass"));
        clickButtonLogIn();
        authorizeAssertion(getConfigurationValue("name"));
        clickToBrowse();
        clickToMainProj();
        clickToAllTasks();
        findTotalNumberOfTasks();
        findTaskTestSelenium(getConfigurationValue("task"));
        checkingStatus("сделать");
        checkingVersion(getConfigurationValue("versionTestValue"));
        outLog();
    }

    @Test
    @Tag("3")
    @DisplayName("Создание новой задачи и полное заполнение всех ее полей")
    public void testTaskNew() {
        open(getConfigurationValue("url"));
        loginVal(getConfigurationValue("name"));
        passwordVal(getConfigurationValue("pass"));
        clickButtonLogIn();
        authorizeAssertion(getConfigurationValue("name"));
        clickToCreateNewTask();
        setIssueType("ошибка");
        setErrorTheme("Похило");
        setErrInfo(getConfigurationValue("info"));
        setFixInVersions();
        setPriority(getConfigurationValue("priority"));
        setHashTag(getConfigurationValue("tag"));
        setMoreInfo(getConfigurationValue("info2"));
        setVersionsAffected();
        clickToAssignMe();
        clickSubmit();
        taskNewPageAssertion();
        outLog();
    }

    @Test
    @Tag("4")
    @DisplayName("Изменение статуса задачи")
    public void testTaskStatus() {
        open(getConfigurationValue("url"));
        loginVal(getConfigurationValue("name"));
        passwordVal(getConfigurationValue("pass"));
        clickButtonLogIn();
        authorizeAssertion(getConfigurationValue("name"));
        clickToFindTask("Похило");
        clickToCheckStatus("сделать");
        clickToSetReady();
        checkFinalStatus("ГОТОВО");
        outLog();
    }
}
