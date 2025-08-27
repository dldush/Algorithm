import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        boolean ok = true;

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();

            while (idx <= target) {
                stack.push(idx++);
                sb.append("+\n");
            }

            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                ok = false;
                break;
            }
        }

        System.out.print(ok ? sb.toString() : "NO\n");
    }
}
