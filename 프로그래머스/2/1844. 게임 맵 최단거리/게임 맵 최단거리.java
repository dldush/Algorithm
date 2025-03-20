import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    public int solution(int[][] maps) {
        int lr = maps.length;
        int lc = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        boolean[][] visited = new boolean[lr][lc];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1], dist = pos[2];

            if (r == lr - 1 && c == lc - 1) return dist;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < lr && 0 <= nc && nc < lc && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    queue.offer(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}
