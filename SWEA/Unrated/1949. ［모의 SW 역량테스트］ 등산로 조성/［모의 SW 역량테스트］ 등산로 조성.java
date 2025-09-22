import java.io.*;
import java.util.*;

public class Solution {
    static int N, K, ans;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dr = {0, -1, 0, 1};
    static final int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            int top = 0;

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    top = Math.max(top, map[r][c]);
                }
            }

            ans = 0;

            // 가장 높은 봉우리들에서 시작
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == top) {
                        dfs(r, c, 1, false); // (r,c)에서 길이 1, 아직 안 깎음
                    }
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    static void dfs(int r, int c, int len, boolean used) {
        ans = Math.max(ans, len);
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;

            if (map[nr][nc] < map[r][c]) { // 그냥 내려갈 수 있으면
                dfs(nr, nc, len + 1, used);
            } else if (!used) { // 아직 안 깎았고, 깎으면 내려갈 수 있는지
                // 현재 칸보다 1 낮게 만들면 가장 유리 (필요 최소치 이상 깎기)
                int need = map[nr][nc] - (map[r][c] - 1); // 내려가려면 최소 need만큼 깎아야 함
                if (need >= 1 && need <= K) {
                    int original = map[nr][nc];
                    map[nr][nc] = map[r][c] - 1; // 임시로 깎아줌
                    dfs(nr, nc, len + 1, true);
                    map[nr][nc] = original;      // 복구
                }
            }
        }

        visited[r][c] = false;
    }
}
