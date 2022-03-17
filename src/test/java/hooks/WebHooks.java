package hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;

/**
 * Класс с настройками веб драйвера и настройки скриншотера Allure
 */

public class WebHooks {

    @BeforeAll
    static void webDriver() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "./src/steps.api.test/resources/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @BeforeAll
    static void allureSettings() {
        new AllureSelenide()
                .screenshots(true)
                .savePageSource(false);
    }

    @AfterAll
    static void webDriverClose() {
        closeWebDriver();
    }
}
