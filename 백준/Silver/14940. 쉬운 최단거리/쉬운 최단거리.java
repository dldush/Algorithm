import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int n, m, cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Queue<int[]> q = new LinkedList<>();
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		visited = new boolean[n][m];
		cnt = 0;
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 2) {
					q.offer(new int[] {r,c});
					visited[r][c] = true;
					map[r][c] = 0;
				} else if(map[r][c] == 1) {
					map[r][c] = -1;
				}
			}
		}
		
		bfs(q);
		
		for(int r = 0; r < n; r++) {
			
			for(int c = 0; c < m; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
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
				if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && map[nr][nc] == -1
						&& map[nr][nc] != 0) {
					q.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
					map[nr][nc] = map[cr][cc]+1;
				}
			}
		}
	} // bfs end

} // class end