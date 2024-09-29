import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cnt = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		makeWall(0);
		System.out.println(max);

	} // main end

	public static void makeWall(int wall) {
		if (wall == 3) {
			countSafe();
			return;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					makeWall(wall + 1);
					map[r][c] = 0;
				}
			}
		}

	} // makeWall end

	public static void countSafe() {
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {

				if (copyMap[r][c] == 2) {
					spread(copyMap, r, c);
				}
			}
		}
		cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copyMap[r][c] == 0) {
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);

	} // count end

	public static void spread(int[][] copyMap, int r, int c) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && copyMap[nr][nc] == 0) {
					q.offer(new int[] { nr, nc });
					copyMap[nr][nc] = 3;
				}
			}

		}

	}

}