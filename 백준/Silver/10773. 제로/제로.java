import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for(int t = 0; t < n; t++) {
            int next = sc.nextInt();
            if(!stack.isEmpty() && next == 0) {
                stack.pop();
            } else {
                stack.push(next);
            }
        }

        while(!stack.isEmpty()) {
            ans += stack.pop();
        }

        System.out.println(ans);
    }
}
