package practice.calculator.mvc.functions;

import practice.calculator.mvc.IFunction;

public class CosineFunction implements IFunction {

    @Override
    public <T> double eval(T operand) {
        return Math.cos(Math.toRadians((double) operand));
    }

}
