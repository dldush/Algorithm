import java.util.*;

class Solution {
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] map;
    static int M, N, cnt, max, colorSize;
    
    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        cnt = 0;
        max = 0;
        map = picture;
        visited = new boolean[m][n];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && map[r][c] != 0) { // 방문하지 않았고 색칠된 부분인 경우
                    colorSize = 1; // 새로운 영역의 크기 초기화
                    bfs(r, c);
                    cnt++;
                    max = Math.max(max, colorSize);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = cnt; // 총 영역의 개수
        answer[1] = max; // 가장 큰 영역의 크기
        return answer;
    }
    
    public void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new int[] {r, c});
        
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];
            for (int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                if (nr >= 0 && nc >= 0 && nr < M && nc < N && !visited[nr][nc] 
                    && map[nr][nc] == map[cr][cc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                    colorSize++;
                }
            }
        }
    }
}
