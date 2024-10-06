import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R, C, cnt, max;
	static char[][] arr;
	static boolean[][] visited;
	static ArrayList<Character> loute;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// initiate var
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		visited = new boolean[R][C];
		loute = new ArrayList<>();
		max = 0;

		// input array
		for (int r = 0; r < R; r++) {
			arr[r] = sc.next().toCharArray();
		}

		dfs(0, 0);
		System.out.println(max);
	} // main end

	static void dfs(int r, int c) {
		visited[r][c] = true;
		loute.add(arr[r][c]);
		cnt = loute.size();
		max = Math.max(max, cnt);  

		direction: for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc]) {
				char tmp = arr[nr][nc];
				
				for (int i = 0; i < loute.size(); i++) {
					if (tmp == loute.get(i)) {
						continue direction;  
					}
				}
				dfs(nr, nc);  
			}
		}
		
		visited[r][c] = false;
		loute.remove(loute.size() - 1);  
	}
}