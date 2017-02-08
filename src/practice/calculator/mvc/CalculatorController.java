package practice.calculator.mvc;

public class CalculatorController {
    private CalculatorView theView;
    private CalculatorModel theModel;
    
    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.setController(this);
    }
    
    private void calculateResult() {
        
        // possible input format exception
        String expression = theView.getExpression();
        
        //possible UnsupportedOperationException
//        theModel.evaluateExpression(firstNumber + operator + secondNumber);
        theModel.evaluate(expression);
        
        theView.setCalcSolution(theModel.getCalculationValue());
        
    }

    public void initialize() {
        theView.initializeDisplay();
    }

    public void processInput() {
        calculateResult();
    }
}
