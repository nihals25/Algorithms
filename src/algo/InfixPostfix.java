package algo;

import java.util.*;

public class InfixPostfix {
    private ArrayDeque<String> stack;
    private Queue<String> q;
    private HashMap<String, Integer> precedenceMap;

    private void initializeHash() {
        precedenceMap = new HashMap<>();
        precedenceMap.put("+", 1);
        precedenceMap.put("-", 1);
        precedenceMap.put("*", 2);
        precedenceMap.put("/", 2);
        precedenceMap.put("%", 2);
        precedenceMap.put("(", 3);
    }

    public InfixPostfix() {
        stack = new ArrayDeque<>();
        q = new LinkedList<>();
        initializeHash();
    }

    private Integer evaluateExpression(String exp) {
        Integer int2 = Integer.parseInt(stack.pop());
        Integer int1 = Integer.parseInt(stack.pop());
        switch (exp) {
            case "+":
                return int1+int2;
            case "-":
                return int1-int2;
            case "*":
                return int1*int2;
            case "/":
                if(int2 == 0)
                    throw new IllegalStateException("Division by zero");
                return int1/int2;
            case "%":
                return int1%int2;
            default:
                return null;
        }
    }

    public String evaluatePostfix(String s) {
        int index = 0;
        do {
            String str = s.substring(index, index+1);
            if("(".equals(str)) {
                index++;
                continue;
            }
            if(")".equals(str))
                break;
            if(precedenceMap.containsKey(str)) {
                stack.push(Integer.toString(evaluateExpression(str)));
            }
            else {
                stack.push(str);
            }
            index++;
        } while(true);
        return stack.pop();
    }

    public static void main(String[] args) {
        String str = "(23*4*)";
        InfixPostfix in = new InfixPostfix();
        System.out.println(in.evaluatePostfix(str));
    }
}
