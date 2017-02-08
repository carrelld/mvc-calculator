package practice.calculator.mvc.functions;

import practice.calculator.mvc.IFunction;

public class TangentFunction implements IFunction {

    @Override
    public <T> double eval(T operand) {
        return Math.tan(Math.toRadians((double) operand));
    }

}
