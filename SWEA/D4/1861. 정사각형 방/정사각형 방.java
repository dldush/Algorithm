import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int[] ans = new int[2];
            ans[0] = 987654321;

            for (int r = 0; r < n; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int cnt = 1;
                    Queue<int[]> q = new ArrayDeque<>();
                    boolean[][] visited = new boolean[n][n];

                    q.offer(new int[] {r, c, arr[r][c]});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cr = cur[0];
                        int cc = cur[1];
                        int val = cur[2];

                        for (int d = 0; d < 4; d++) {
                            int nr = cr + dr[d];
                            int nc = cc + dc[d];

                            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && arr[nr][nc] == val + 1) {
                                    visited[nr][nc] = true;
                                    q.offer(new int[]{nr, nc, arr[nr][nc]});
                                    cnt++;
                            }
                        }
                    } // while end
                    if (cnt > ans[1]) {
                        ans[1] = cnt;
                        ans[0] = arr[r][c];
                    } else if (cnt == ans[1] && arr[r][c] < ans[0]) {
                        ans[0] = arr[r][c];
                    }
                }
            }

            System.out.println("#" + t + " " + ans[0] + " " + ans[1]);
        }
    }
}
