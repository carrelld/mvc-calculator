import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Evaluator {

    public static final Map<String, Operable> validOperators = new HashMap<String, Operable>();
    static {
        validOperators.put("+", new Operable() {
            public int operate(int left, int right) { 
                return left + right; 
            }
        });
        validOperators.put("-", new Operable() {
            public int operate(int left, int right) { 
                return left - right; 
            }
        });
        validOperators.put("*", new Operable() {
            public int operate(int left, int right) { 
                return left * right; 
            }
        });
        validOperators.put("/", new Operable() {
            public int operate(int left, int right) { 
                return left / right; 
            }
        });
    }
    
    public long evaluate(String s) {
        
        String[] rawExpression = s.split(" ");
        Stack<Integer> operands = new Stack<Integer>();
        
        for (int i = 0; i < rawExpression.length; i++) {
            String item = rawExpression[i];
            if (isInt(item)) {
                operands.push(Integer.parseInt(item));
            } else {
                assert validOperators.containsKey(item) : "Invalid operator supplied";
                assert operands.size() >= 2 : "Not enough leading operands for valid evaluation";
                // evaluation step
                int right = operands.pop();
                int left = operands.pop();
                int result = validOperators.get(item).operate(left, right);
                operands.push(result);
            }
        }
        
        assert operands.size() == 1;
        return operands.pop();
    }
    
    private static boolean isInt(String s) {
        char localeMinusSign = DecimalFormatSymbols.getInstance().getMinusSign();
        boolean isNegative = s.charAt(0) == localeMinusSign && s.length() != 1;
        if (!Character.isDigit(s.charAt(0)) && !isNegative) {
            return false;
        } else if (s.length() > 1) {
            for (Character c : s.substring(1).toCharArray()) {
                if (!Character.isDigit(c)) { return false; }
            }
        }
        return true;
    }
    
    private interface Operable {
        int operate(int left, int right);
    }

}
