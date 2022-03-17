package PageObject.PageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static PageObject.PageElements.DashboardElem.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс содержащий в себе шаги открытия страницы дашборда и работы со списком задач
 */

public class DashboardSteps {

    @Step("Переходим на страницу задач")
    public static void openTasksList() {
        $x(projectsLink).click();
        $x(testsLink).click();
        $x(testsSection).click();
    }

    @Step("Сверяем количество отображаемых задач с указанным общим количеством задач")
    public static void findTasksCount() {
        int tasksValue = Integer.parseInt(($x(tasksCount).text().split(" "))[0]);
        int contentValue = $$(By.xpath(content)).size();

        Assertions.assertEquals(tasksValue, contentValue);
    }

}
