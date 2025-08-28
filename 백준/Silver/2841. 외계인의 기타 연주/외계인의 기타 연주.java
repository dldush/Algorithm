import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int ans = 0;

        Deque<Integer>[] stack = (Deque<Integer>[]) new Deque[7];

        for (int i = 0; i < 7; i++) {
            stack[i] = new ArrayDeque<>();
        }

        for (int t = 0; t < n; t++) {
            int line = sc.nextInt();
            int pret = sc.nextInt();

            if (stack[line].isEmpty()) {
                stack[line].push(pret);
                ans++;
            } else {
                if (stack[line].peek() > pret) {
                    while (!stack[line].isEmpty() && stack[line].peek() > pret) {
                        stack[line].pop();
                        ans++;
                    }
                    if (stack[line].isEmpty() || stack[line].peek() < pret) {
                        stack[line].push(pret);
                        ans++;
                    }
                } else if (stack[line].peek() < pret) {
                    stack[line].push(pret);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
