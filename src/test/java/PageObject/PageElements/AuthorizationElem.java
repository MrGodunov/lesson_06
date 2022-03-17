package PageObject.PageElements;

/**
 * Класс содержащий в себе UI эллементы, нацеленные на авторизацию
 */

public class AuthorizationElem {

    public static String fieldLoginJira = "//input[@id='login-form-username']";

    public static String fieldPasswordJira = "//input[@id='login-form-password']";

    public static String buttonLoginJira = "//input[@id='login-form-submit']";

    public static String buttonCantLoginJira = "//a[@id='login-form-cancel']";
}
