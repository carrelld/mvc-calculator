package practice.calculator.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import practice.calculator.mvc.functions.Functions;

import java.util.regex.Matcher;

public class CalculatorModel {

    // make an actual factory to generate concrete objects rather than global variable
    public static final EvaluationStrategy EVAL_STRAT_RECURSIVE = new RecursiveParser();
    
    // TODO implement a "history" for the calculator to cache and recall previous operations
    private List<Calculation> history = new ArrayList<Calculation>();
    private int calculationValue;
    
    public void evaluate(String expression) {
        Calculation calculation = new Calculation(expression);
        calculation.eval();
        history.add(calculation);
    }
    
    public String getCalculationValue() {
        return this.history.get(history.size() - 1).getResult();
    }
    
}

class Calculation {
    private EvaluationStrategy evaluator;
    private final String expression;
    private String result;
    
    public Calculation(String expression, EvaluationStrategy evalStrategy) {
        this.expression = expression;
        this.evaluator = evalStrategy;
    }

    public Calculation(String expression) {
        this(expression, CalculatorModel.EVAL_STRAT_RECURSIVE);
    }
    
    public void eval() {
        result = evaluator.evaluate(this);
    }
    
    public String getResult() {
        return result;
    }
    public String getExpression() {
        return expression;
    }

}
