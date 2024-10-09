import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int N, T;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); 
			
			Queue<int[]> q = new LinkedList<>();

			int sy = sc.nextInt();
			int sx = sc.nextInt();
			int ty = sc.nextInt();
			int tx = sc.nextInt();
			
			visited = new boolean[N][N];
			map = new int[N][N];

			q.offer(new int[] { sy, sx });
			visited[sy][sx] = true;

			bfs(q);
			
			System.out.println(map[ty][tx]);
		}
	} // main end

	static void bfs(Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int cr = tmp[0];
			int cc = tmp[1];
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(nr>=0&&nc>=0&&nr<N&&nc<N&&!visited[nr][nc]&&map[nr][nc]==0) {
					q.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
					map[nr][nc] = map[cr][cc] + 1;
				}
			}
		}
	} // bfs end

} // class end