package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static PageObject.PageElements.DashboardElem.*;
import static PageObject.PageElements.ProjectElem.*;
import static Utils.Configuration.getFromProperties;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Класс содержащий в себе шаги работы с созданием новой задачи
 */

public class ProjectSteps {

    @Step("Создаем задачу")
    public static void createTask() {
        $x(btnCreateTask).click();
        $x(taskNameLane).sendKeys(getFromProperties("taskName"));
        $x(taskInfo).sendKeys(getFromProperties("taskInfoText"));
        $x(btnSubmitTask).click();
    }

    @Step("Переходим на страницу созданной задачи")
    public static void openNewTask() {
        $x(newTaskLink).click();
    }

    @Step("Переводим задачу в работу и отмечаем выполненной")
    public static void statusNewTask() {
        $x(taskStatusBtn).click();
        $x(taskStatusList).click();
        $x(taskStatusDone).click();
    }

    @Step("Проверяем статус задачи")
    public static void checkNewTask() {
        assertTrue($x(taskStatusDone).shouldBe(visible, Duration.ofSeconds(60)).exists());
        $x(taskCheckStatus).shouldBe(Condition.text("ГОТОВО"));
    }
}