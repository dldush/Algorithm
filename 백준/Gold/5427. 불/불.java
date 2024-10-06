import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int w, h;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> fireQueue;
	static Queue<int[]> personQueue;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// initiate var
			w = sc.nextInt();
			h = sc.nextInt();
			map = new char[h][w];
			visited = new boolean[h][w];
			fireQueue = new LinkedList<>();
			personQueue = new LinkedList<>();

			// input array & find person, fire
			for (int r = 0; r < h; r++) {
				map[r] = sc.next().toCharArray();
				for (int c = 0; c < w; c++) {
					if (map[r][c] == '@') {
						personQueue.offer(new int[] { r, c });
						map[r][c] = '.';
					}
					if (map[r][c] == '*') {
						fireQueue.offer(new int[] { r, c });
					}
				}
			}

			int result = bfs();

			if (result == -1) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}

		} // tc end

	} // main end

	static int bfs() {
		int time = 0;

		while (!personQueue.isEmpty()) {
			time++;

			int fireSize = fireQueue.size();
			for (int i = 0; i < fireSize; i++) {
				int[] tmp = fireQueue.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = tmp[0] + dr[dir];
					int nc = tmp[1] + dc[dir];
					if (nr >= 0 && nc >= 0 && nr < h && nc < w && map[nr][nc] == '.') {
						fireQueue.offer(new int[] { nr, nc });
						map[nr][nc] = '*';
					}
				}
			} // fire end

			int personSize = personQueue.size();
			for (int i = 0; i < personSize; i++) {
				int[] tmp = personQueue.poll();
				if(tmp[0] == 0 || tmp[1] == 0 || tmp[0] == h-1 || tmp[1] == w-1) {
					return time;
				}
				
				for (int dir = 0; dir < 4; dir++) {
					int nr = tmp[0] + dr[dir];
					int nc = tmp[1] + dc[dir];
					if(nr >= 0 && nc >= 0 && nr < h && nc < w && map[nr][nc] == '.' && !visited[nr][nc]) {
						personQueue.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
				}
			} // person end
		} // while end
		return -1;
	} // bfs end

} // class end