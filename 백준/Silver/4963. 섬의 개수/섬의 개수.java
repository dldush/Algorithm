import java.util.Scanner;

public class Main {

	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; 
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static int w, h, cnt;
	static boolean[][] visited;
	static int[][] land;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			// initiate var
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			land = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;

			// input array
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					land[r][c] = sc.nextInt();
				}
			}

			// dfs
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (land[r][c] == 1 && !visited[r][c]) {
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

		for (int dir = 0; dir < 8; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr >= 0 && nc >= 0 && nr < h && nc < w && land[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}

	}

} // class end