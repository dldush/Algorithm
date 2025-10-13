import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        if (N != 1) {
            for (int i = 1; i < N; i++) {
                pq.offer(Integer.parseInt(br.readLine()));
            }

            while (pq.peek() >= M) {
                int tmp = pq.poll();
                tmp--;
                M++;
                ans++;
                pq.offer(tmp);
            }
        }

        System.out.println(ans);
    }
}
