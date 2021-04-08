package linear;

import java.util.Stack;

public class BalancedString {

    private String chainToBalance;


    public BalancedString(String chainToBalance) {
        this.chainToBalance = chainToBalance;
    }

    public boolean isBalanced(){

        Stack<Character> stack = new Stack<>();

        for(char c : chainToBalance.toCharArray()){
            switch (c) {

                case '[':
                case '{':
                    stack.push(c);
                         break;
                case '(' : stack.push(c);
                           break;
                case ']' : if (stack.isEmpty() || stack.pop() != '[')
                           return false;
                           break;
                case '}' : if (stack.isEmpty() || stack.pop() != '{')
                            return false;
                            break;
                case ')' : if (stack.isEmpty() || stack.pop() != '(')
                            return false;
                            break;
            }
        }

      return stack.isEmpty();

    }
}
