package practice.calculator.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import practice.calculator.mvc.functions.Functions;

import java.util.regex.Matcher;

public class CalculatorModel {

    // TODO implement a "history" for the calculator to cache and recall previous operations
    private List<Calculation> history = new ArrayList<Calculation>();
    private int calculationValue;
    
    public void evaluate(String expression) {
        Calculation calculation = new Calculation(expression);
        calculation.evaluate();
        history.add(calculation);
    }
    /**
     * Evaluate a mathematical expression
     * @param expression assumes integer result, single operator (multiply or add), two integer operands
     * 
     * TODO Better evaluation engine that can be improved by using a functional interface
     * http://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
     */
    public void evaluateExpression(String expression) {
        Pattern p = Pattern.compile("^(-?\\d+)([+*])(-?\\d+)$");
        Matcher m = p.matcher(expression);
        if (m.find()) {
            int left = Integer.parseInt(m.group(1));
            int right = Integer.parseInt(m.group(3));
            
            switch (m.group(2)) {
            case "+": calculationValue = left + right;
                      break;
            case "*": calculationValue = left * right;
                      break;
            default:  throw new UnsupportedOperationException(m.group(2) + " operator not recognized");

            }
        } else {
            throw new UnsupportedOperationException("The evalution string '" + expression + "' cannot be evaluated");
        }
    }
    
    public String getCalculationValue() {
        return this.history.get(history.size() - 1).getResult();
    }
    
}

class Calculation {
    private final String expression;
    private String result;
    
    public Calculation(String expression) {
        this.expression = expression;
    }
    
    public String getResult() {
        return result;
    }
    public String getExpression() {
        return expression;
    }

    public void evaluate() {
        /*
         * http://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
         */
        Double evaluation = new Object() {
            int pos = -1, ch;
            String str = expression;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    IFunction function = Functions.getFunction(func);
                    x = function.eval(x);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
        
        result = Double.toString(evaluation);
    }
}
