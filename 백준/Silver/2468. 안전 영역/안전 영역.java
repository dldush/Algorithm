import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[][] visited;
	static int[][] land;
	static int N, day, max, cnt;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		land = new int[N][N];
		visited = new boolean[N][N];
		day = 0;
		max = 0;
		cnt = 0;

		// input array
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				land[r][c] = sc.nextInt();
			}
		}

		for (int d = 0; d < 100; d++) {
			cnt = 0;
			visited = new boolean[N][N];
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					bfs(r, c);
				}
			}
			max = Math.max(max, cnt);
			day++;
		}
		System.out.println(max);
	} // main end

	static void bfs(int r, int c) {
		if (!visited[r][c] && land[r][c] > day) {
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { r, c });

			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = tmp[0] + dr[dir];
					int nc = tmp[1] + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && land[nr][nc] > day) {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			cnt++;
		}
	}

} // class end