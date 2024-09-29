import java.util.Scanner;

public class Solution {

	static boolean[][] visited;
	static char[][] miro;
	static boolean answer;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int T = sc.nextInt();

			miro = new char[16][16];
			visited = new boolean[16][16];

			for (int r = 0; r < 16; r++) {
				miro[r] = sc.next().toCharArray();
			}

			int A = 0;
			int B = 0;

			for (int r = 0; r < 16; r++) {
				for (int c = 0; c < 16; c++) {
					if (miro[r][c] == '2') {
						A = r;
						B = c;
					}
				}
			}
			answer = false;
			dfs(A, B);

			if (answer) {
				System.out.println("#" + T + " 1");
			} else {
				System.out.println("#" + T + " 0");
			}

		} // tc end

	} // main end

	static void dfs(int r, int c) {
		visited[r][c] = true;
		if (miro[r][c] == '3') {
			answer = true;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nc >= 0 && nr < 16 && nc < 16 && miro[nr][nc] != '1' && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}

		}

	}
}