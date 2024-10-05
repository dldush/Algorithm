import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static char[][] pic;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int rcnt, gcnt, bcnt, rgcnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		pic = new char[N][N];
		visited = new boolean[N][N];
		rcnt = 0;
		gcnt = 0;
		bcnt = 0;
		rgcnt = 0;
		int ans1 = 0;
		int ans2 = 0;

		// input array
		for (int r = 0; r < N; r++) {
			pic[r] = sc.next().toCharArray();
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				rbfs(r, c);
				gbfs(r, c);
				bbfs(r, c);
			}
		}
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				rgbfs(r, c);
			}
		}
		ans1 = rcnt + gcnt + bcnt;
		ans2 = rgcnt + bcnt;
		System.out.println(ans1 + " " + ans2);

	} // main end

	static void rbfs(int r, int c) {
		if (!visited[r][c] && pic[r][c] == 'R') {
			visited[r][c] = true;
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { r, c });
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = tmp[0] + dr[dir];
					int nc = tmp[1] + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && pic[nr][nc] == 'R') {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			rcnt++;
		}
	} // rbfs end

	static void gbfs(int r, int c) {
		if (!visited[r][c] && pic[r][c] == 'G') {
			visited[r][c] = true;
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { r, c });
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = tmp[0] + dr[dir];
					int nc = tmp[1] + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && pic[nr][nc] == 'G') {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			gcnt++;
		}
	} // gbfs end

	static void bbfs(int r, int c) {
		if (!visited[r][c] && pic[r][c] == 'B') {
			visited[r][c] = true;
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { r, c });
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = tmp[0] + dr[dir];
					int nc = tmp[1] + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && pic[nr][nc] == 'B') {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			bcnt++;
		}
	} // gbfs end

	static void rgbfs(int r, int c) {
		if (!visited[r][c] && (pic[r][c] == 'G' || pic[r][c] == 'R')) {
			visited[r][c] = true;
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { r, c });
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = tmp[0] + dr[dir];
					int nc = tmp[1] + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && (pic[nr][nc] == 'G'
							|| pic[nr][nc] == 'R')) {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			rgcnt++;
		}
	} // gbfs end

} // class end