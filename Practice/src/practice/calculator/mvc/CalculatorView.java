package practice.calculator.mvc;

public interface CalculatorView {

    void setCalcSolution(String string);

    void initializeDisplay();
    
    void setController(CalculatorController controller);

    void displayErrorMessage(String string);

    String getExpression();

}
