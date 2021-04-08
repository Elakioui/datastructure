package linear;

import java.util.Stack;

public class StringReverser {

    public String reverse(String str){

        if(str == null || str.isEmpty())
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        char[] caracters = str.toCharArray();

        for (char c : caracters){
            stack.push(c);
        }

        int index = 0;

        while(!stack.isEmpty()){
            caracters[index++] = stack.pop();
        }

        return String.copyValueOf(caracters);
    }
}
