import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageObject.PageSteps.AuthorizationSteps.*;
import static PageObject.PageSteps.DashboardSteps.*;
import static PageObject.PageSteps.ProjectSteps.*;
import static Utils.Configuration.getFromProperties;

public class JiraTests {

    @Test
    @Tag("Jira")
    @DisplayName("Проверка общего количества заведенных задач")
    public void Test1() {
        openUrl(getFromProperties("jiraUrl"));
        authorization(getFromProperties("LoginJira"));
        openTasksList();
        findTasksCount();
    }

    @Test
    @Tag("Jira")
    @DisplayName("Проверка создания новой задачи и изменения ее статусов")
    public void Test2() {
        openUrl(getFromProperties("jiraUrl"));
        authorization(getFromProperties("LoginJira"));
        createTask();
        openNewTask();
        statusNewTask();
        checkNewTask();
    }
}
