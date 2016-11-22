package practice.calculator.mvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorModelTest {

    
    private CalculatorModel model = new CalculatorModel();
    
    @Test
    public void evaluateAddition() {
        String expression = "9+5";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        
        assertTrue("Incorrect value", doubleResult == 14);
    }
    @Test
    public void evaluateSubtraction() {
        String expression = "9-5";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        
        assertTrue("Incorrect value", doubleResult == 4);
    }
    @Test
    public void evaluateMultiplication() {
        String expression = "9*5";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        
        assertTrue("Incorrect value", doubleResult == 45);
    }
    @Test
    public void evaluateDivision() {
        String expression = "9/5";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        
        assertTrue("Incorrect value", doubleResult == 1.8);
    }
    @Test
    public void evaluateSine() {
        String expression = "sin(3.14)";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        // TODO how to check the results are actually within the bounds of Double imprecision
        assertTrue("Incorrect value", doubleResult >= 0.05477590985 && doubleResult <= 0.05477590986);
    }
    @Test
    public void evaluateCosine() {
        String expression = "cos(90)";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        System.out.println(doubleResult);
        
        assertTrue("Incorrect value", doubleResult >= -0.00000000001 && doubleResult <= 0.00000000001);
    }
    @Test
    public void evaluateTangent() {
        String expression = "tan(3.14)";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        System.out.println(doubleResult);
        // TODO how to check the results are actually within the bounds of Double imprecision
        assertTrue("Incorrect value", doubleResult >= 0.05485827005 && doubleResult <= 0.05485827007);
    }
    @Test
    public void evaluateFactorial() {
        String expression = "fact(5)";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        System.out.println(doubleResult);
        assertTrue("Incorrect value", doubleResult == 120);
    }
    @Test
    public void evaluateNegativeOperands() {
        String expression = "-15+30";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        
        assertTrue("Incorrect value", doubleResult == 15);
    }
    @Test
    public void evaluateNegativeResults() {
        String expression = "15-30";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        
        assertTrue("Incorrect value", doubleResult == -15);
    }
    @Test
    public void evaluateSpaces() {
        String expression = " 9  +      5 ";
        
        model.evaluate(expression);
        String result = model.getCalculationValue();
        Double doubleResult = Double.parseDouble(result);
        
        assertTrue("Incorrect value", doubleResult == 14);
    }
    @Test(expected=RuntimeException.class)
    public void evaluateInvalidEscapedCharacters() {
        String expression = " 9  +\n\t\r5 ";
        model.evaluate(expression);
    }

}
