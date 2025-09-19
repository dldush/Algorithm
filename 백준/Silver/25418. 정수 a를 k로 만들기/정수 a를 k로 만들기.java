import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int A, K;

    public static int bfs(int cur, int depth) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[K + 1];
        q.offer(new int[] {cur, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == K) {
                return tmp[1];
            }

            int c = tmp[0];
            int d = tmp[1];

            if (c * 2 <= K && !visited[c * 2]) {
                visited[c * 2] = true;
                q.offer(new int[] {c * 2, d + 1});
            }
            if (c + 1 <= K && !visited[c + 1]) {
                visited[c + 1] = true;
                q.offer(new int[] {c + 1, d + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, 0));
    }
}
