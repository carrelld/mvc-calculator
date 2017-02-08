package practice.calculator.mvc.functions;

import practice.calculator.mvc.IFunction;

public class FactorialFunction implements IFunction {

    @Override
    public <T> double eval(T operand) {
        try {
            return factorial((int) Math.round((double) operand));            
        } catch (Exception e) {
            throw new RuntimeException("Factorial can only be run on integers");
        }
    }
    
    private long factorial(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

}
