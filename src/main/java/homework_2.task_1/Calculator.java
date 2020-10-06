package homework_2.task_1;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.startApplication();
    }

    public void startApplication() {
        System.out.println("Calculator loaded...\n" +
                "Available operation:\n" +
                "+ - addition\n" +
                "- - subtraction\n" +
                "* - multiplication\n" +
                "^ - exponentiation\n" +
                "! - factorial\n" +
                "f - fibonacci\n" +
                "Select operation:");
        Scanner in = new Scanner(System.in);
        String operation = in.next();

        double num1;
        double num2;

        switch (operation) {
            case ("+"):
                num1 = getValueFromConsole("first number");
                num2 = getValueFromConsole("second number");
                printResult(getAddResult(num1, num2));
                break;
            case ("-"):
                num1 = getValueFromConsole("first number");
                num2 = getValueFromConsole("second number");
                printResult(getSubResult(num1, num2));
                break;
            case ("*"):
                num1 = getValueFromConsole("first number");
                num2 = getValueFromConsole("second number");
                printResult(getMultiplyResult(num1, num2));
                break;
            case ("^"):
                num1 = getValueFromConsole("base");
                num2 = getValueFromConsole("exponent");
                printResult(getExpResult((int) num1, (int) num2));
                break;
            case ("!"):
                num1 = getValueFromConsole("number");
                printResult(getFactorialResult((int) num1));
                break;
            case ("f"):
                num1 = getValueFromConsole("number");
                printResult(getFibonacciResult((int) num1));
                break;
            default:
                System.out.println("Operation <" + operation + "> not supported!");
                break;
        }

    }

    private double getValueFromConsole(String name) {
        System.out.println("Enter " + name + ":");
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }

    private void printResult(double result) {
        System.out.println("Result: " + result);
    }

    private double getAddResult(double num1, double num2) {
        return num1 + num2;
    }

    private double getSubResult(double num1, double num2) {
        return num1 - num2;
    }

    private double getMultiplyResult(double num1, double num2) {
        return num1 * num2;
    }

    private double getExpResult(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private double getFactorialResult(int number) {
        int result = 1;
        for (int i = 1; i < number; i++) {
            result *= i;
        }
        return result;
    }


    private double getFibonacciResult(int number) {
        int first = 0;
        int second = 1;
        if (number == 0) return first;
        for (int i = 2; i <= number; ++i) {
            int next = first + second;
            first = second;
            second = next;
        }
        return second;
    }

}
