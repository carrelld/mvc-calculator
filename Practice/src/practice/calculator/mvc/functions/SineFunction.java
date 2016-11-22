package practice.calculator.mvc.functions;

import practice.calculator.mvc.IFunction;

public class SineFunction implements IFunction {

    @Override
    public <T> double eval(T operand) {
        return Math.sin(Math.toRadians((double) operand));
    }

}
