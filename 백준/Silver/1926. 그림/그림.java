import java.util.Scanner;

public class Main {

	static int n, m;
	static boolean[][] visited;
	static int[][] pic;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int size;
	static int count;
	static int max;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		pic = new int[n][m];
		visited = new boolean[n][m];
		size = 0;
		count = 0;
		max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				pic[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pic[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					count++;
					max = Math.max(size, max);
					size = 0;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
		

	} // main end

	public static void dfs(int r, int c) {
		visited[r][c] = true;
		size++;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && pic[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}

	} // dfs end

}