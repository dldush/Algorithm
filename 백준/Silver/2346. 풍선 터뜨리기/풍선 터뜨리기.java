import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> dq = new ArrayDeque<>(); 
        for (int i = 1; i <= N; i++) {
            dq.offerLast(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();          
            sb.append(cur[0]).append(' ');
            if (dq.isEmpty()) break;             

            int k = cur[1];
            if (k > 0) {
                for (int i = 1; i < k; i++) dq.offerLast(dq.pollFirst());
            } else {
                for (int i = 0; i < -k; i++) dq.offerFirst(dq.pollLast());
            }
        }
        System.out.println(sb.toString());
    }
}
