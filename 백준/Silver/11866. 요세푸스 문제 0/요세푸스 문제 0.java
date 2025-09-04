import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        while (!q.isEmpty()) {
            for (int i = 1; i < K; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll());
            if (!q.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
