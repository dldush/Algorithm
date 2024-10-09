import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int N, M, max;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		visited = new boolean[N][M];
		map = new int[N][M];
		max = 0;
		boolean impossible = false;
		Queue<int[]> q = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 1) {
					q.offer(new int[] { r, c });
					visited[r][c] = true;
				}
			}
		}

		bfs(q);
		
//		System.out.println(startR+" "+startC);
		
//		System.out.println(Arrays.deepToString(map));

		outer: for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					impossible = true;
					break outer;
				} else {
					max = Math.max(max, map[r][c]);
				}
			}
		}
		
		
		
		if (impossible) {
			System.out.println(-1);
		} else {
			System.out.println(max-1);
		}
	} // main end

	static void bfs(Queue<int[]> q) {

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int cr = tmp[0];
			int cc = tmp[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] != -1) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
					map[nr][nc] = map[cr][cc] + 1;
				}
			}
		}

	} // bfs end

} // class end