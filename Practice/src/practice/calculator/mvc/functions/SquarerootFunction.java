package practice.calculator.mvc.functions;

import practice.calculator.mvc.IFunction;

public class SquarerootFunction implements IFunction {

    @Override
    public <T> double eval(T operand) {
        return Math.sqrt((double) operand);
    }

}
