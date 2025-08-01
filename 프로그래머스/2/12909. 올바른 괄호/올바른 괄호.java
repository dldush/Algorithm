import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] set = new char[s.length()];
        set = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        // if first character is ')'
        boolean answer = true;
        if(set[0] == ')') {
            answer = false;
            return answer;
        }
        //pushing '(' to stack, check and pop
        for(int i = 0; i < set.length; i++) {
            if(set[i] == '(') {
                stack.push('(');
            }
            if(set[i] == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    answer = false;
                    return answer;
                }
            }
        }
        // checking stack
        if(!stack.isEmpty()) {
            answer = false;
            return answer;
        }
        return answer;
    }
}