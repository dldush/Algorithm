import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] miro;
	static int N, M, cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		miro = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for(int c = 0; c < M; c++) {
				miro[r][c] = str.charAt(c) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(miro[N-1][M-1]);

	} // main end

	static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			cnt++;
			int[] tmp = q.poll();
			int cr = tmp[0];
			int cc = tmp[1];
			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && miro[nr][nc] == 1) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
					miro[nr][nc] = miro[cr][cc] + 1;
				}
			}
		}

	} // bfs end
}