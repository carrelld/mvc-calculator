package practice.calculator.mvc;

public class MVCCalculator {

    public static void main(String[] args) {

        CalculatorController swingCalc = new CalculatorController(new SwingView(), new CalculatorModel());
        swingCalc.initialize();
        
        CalculatorController consoleCalc = new CalculatorController(new ConsoleView(System.in), new CalculatorModel());
        consoleCalc.initialize();
        
    }
    
}
