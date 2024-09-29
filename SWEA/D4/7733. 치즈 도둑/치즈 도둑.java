import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;
	static int[][] refridge;
	static int max;
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			
			refridge = new int[N][N];
			max = 0;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					refridge[r][c] = sc.nextInt();
				}
			}

			for (int i = 0; i < 100; i++) {
				visited = new boolean[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (refridge[r][c] == i) {
							refridge[r][c] = 0;
						}
					}
				}
				cnt = 0;
				for (int a = 0; a < N; a++) {
					for (int b = 0; b < N; b++) {
						if(!visited[a][b] && refridge[a][b] > 0)
						bfs(a, b);
					}
				}
				max = Math.max(max, cnt);
			}
			System.out.println("#"+tc+" "+max);
		} // tc end

	} // main end

	static void bfs(int r, int c) {
		if (!visited[r][c]) {
			visited[r][c] = true;

			Queue<int[]> q = new LinkedList<>();

			q.offer(new int[] { r, c });

			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = tmp[0] + dr[d];
					int nc = tmp[1] + dc[d];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && refridge[nr][nc] != 0) {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}

				}
			}
			cnt++;
		}
	} // bfs end

}