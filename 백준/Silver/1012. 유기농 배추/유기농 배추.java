import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, K;
	static boolean[][] visited;
	static int[][] baechu;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			M = sc.nextInt(); // column
			N = sc.nextInt(); // row
			K = sc.nextInt();
			cnt = 0;

			baechu = new int[N][M];
			visited = new boolean[N][M];

			// input array
			for (int i = 0; i < K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				baechu[Y][X] = 1;
			}
			for(int r = 0 ; r < N; r++) {
				for(int c = 0 ; c < M; c++) {
					bfs(r, c);
				}
			}
			System.out.println(cnt);

		} // tc end

	} // main end

	static void bfs(int r, int c) {
		if (baechu[r][c] == 1 && !visited[r][c]) {
			visited[r][c] = true;
			Queue<int[]> q = new LinkedList<>();

			q.offer(new int[] { r, c });

			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = tmp[0] + dr[dir];
					int nc = tmp[1] + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && baechu[nr][nc] == 1) {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			cnt++;
		}
	} // bfs end
} // class end