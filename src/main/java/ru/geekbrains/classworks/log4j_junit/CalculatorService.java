package ru.geekbrains.classworks.log4j_junit;

public class CalculatorService {
    private Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(int a, int b) {
        return calculator.add(a, b);
    }

    public int subtract(int a, int b) {
        return calculator.sub(a, b);
    }

    public int multiply(int a, int b) {
        return calculator.mul(a, b);
    }

    public int divide(int a, int b) {
        return calculator.div(a, b);
    }
}
