import java.util.Scanner;

public class Main {

	static boolean[][] visited;
	static int N, M, K, cnt;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			cnt = 0;

			for (int i = 0; i < K; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = 1;
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1 && !visited[r][c]) {
						dfs(r, c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		} // tc end

	} // main end

	static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}

	}

}