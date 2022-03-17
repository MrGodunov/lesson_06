package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.AuthorizationElem.*;
import static Utils.Configuration.getFromProperties;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * Класс содержащий в себе шаги авторизации
 */

public class AuthorizationSteps {

    @Step("Открываем страницу по ссылке {url}")
    public static void openUrl(String url) {
        open(url);
    }

    @Step("Авторизуемся в системе пользователем {login}")
    public static void authorization(String login) {
        $x(fieldLoginJira).sendKeys(getFromProperties("LoginJira"));
        $x(fieldPasswordJira).sendKeys(getFromProperties("PasswordJira"));
        $x(buttonLoginJira).click();
    }
}
