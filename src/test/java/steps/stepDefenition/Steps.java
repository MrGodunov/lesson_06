package steps.stepDefenition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

public class Steps {
    int a;
    int b;
    double result;
    String operation;

    @Дано("^два числа (.*) и (.*)$")
    public void given(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Тогда("^находим (.*) двух числел$")
    public void result(String operation) {
        switch (operation) {
            case "сумму":
                this.operation = "Сумма";
                this.result = a + b;
                break;
            case "разность":
                this.operation = "Разность";
                this.result = a - b;
                break;
            case "произведение":
                this.operation = "Произведение";
                this.result = a * b;
                break;
            case "частное":
                this.operation = "Частное";
                this.result = (float) a / b;
                break;
        }
    }

    @И("^выводим результат на экран$")
    public void printResult() {
        System.out.println(operation + " чисел " + a + " и " + b + " ровняется " + result);
    }
}
