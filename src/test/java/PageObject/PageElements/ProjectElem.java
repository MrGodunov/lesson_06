package PageObject.PageElements;

/**
 * Класс содержащий в себе UI эллементы страницы создания новой задачи
 */

public class ProjectElem {

    public static String taskNameLane = "//input[@id='summary']";

    public static String taskInfo = "//*[@id='description']";

    public static String btnSubmitTask = "//input[@id='create-issue-submit']";

    public static String newTaskLink = "//*[@id='aui-flag-container']/div/div/a";

    public static String taskStatusBtn = "//a[@id='action_id_21']";

    public static String taskStatusList = "//a[@id='opsbar-transitions_more']";

    public static String taskStatusDone = "//a[@id='action_id_31']";

    public static String taskCheckStatus = "//*[@id='status-val']/span";

}
