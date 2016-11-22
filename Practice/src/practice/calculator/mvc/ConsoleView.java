package practice.calculator.mvc;

import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleView implements CalculatorView {
    
    private final Scanner scanner;
    private CalculatorController controller;
    
    public ConsoleView(InputStream is) {
        this.scanner = new Scanner(is);
    }

    private void newCalculation() {
        controller.processInput();
    }
    
    public void initializeDisplay() {
        System.out.println("-- This is the Console view of the Calculator --");
        newCalculation();
    }

    public void setCalcSolution(String calculationValue) {
        System.out.println(String.format("Result: %10s", calculationValue));
        newCalculation();
    }
    
    public void setController(CalculatorController controller) {
        this.controller = controller;
    }
    
    public void displayErrorMessage(String string) {
        System.out.println(string);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newCalculation();
    }
    
    @Override
    public String getExpression() {
        return getFirstNumber() + getOperator() + getSecondNumber();
    }
    
    private int getFirstNumber() {
        return Integer.parseInt(requestInput("Enter your first value: "));
    }

    private int getSecondNumber() {
        return Integer.parseInt(requestInput("Enter your second value: "));
    }

    private String getOperator() {
        return requestInput("Which operation? **(only * and + work at this time)");
    }
    
    private String requestInput(String message) {
        System.out.print(message);
        String s = scanner.nextLine();
        return s;
    }


}
