import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int t = 0; t < n; t++) {
            char[] cur = sc.next().toCharArray();
            Stack<Character> stack = new Stack<>();

                for (int i = 0; i < cur.length; i++) {
                    if(stack.isEmpty()) {
                        stack.push(cur[i]);
                    } else {
                        if(cur[i] == ')' && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(cur[i]);
                        }
                    }
                }
                
            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
