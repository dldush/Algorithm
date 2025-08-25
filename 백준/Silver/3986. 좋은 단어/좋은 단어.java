import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        // n = amount of words
        for(int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            // getting current line
            char[] cur = sc.next().toCharArray();
            // setting index
            for(int idx = 0; idx < cur.length; idx++) {
                // if stack is empty
                if(stack.isEmpty()) {
                    stack.push(cur[idx]);
                } else {
                    // stack is not empty && top of stack is same as current char -> pop the char
                    if(cur[idx] == stack.peek()) {
                        stack.pop();
                    } else {
                        // stack is not empty && top of stack is not same as current char -> push new char
                        stack.push(cur[idx]);
                    }
                }
            } // words end

            if(stack.isEmpty()) {
                answer++;
            }
        } // test cases end

        System.out.println(answer);
    } // main end
}
