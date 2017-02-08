package practice.calculator.mvc.functions;

import practice.calculator.mvc.IFunction;

public class Functions {

    public static IFunction getFunction(String functionCall) {
        switch (functionCall.toLowerCase()) {
        case "sqrt":
            return new SquarerootFunction();
        case "sin":
            return new SineFunction();
        case "cos":
            return new CosineFunction();
        case "tan":
            return new TangentFunction();
        case "factorial":
        case "fact":
            return new FactorialFunction();
        default:
            throw new UnsupportedOperationException(functionCall.toLowerCase() + " is not a supported function");
        }
    }
    
}
