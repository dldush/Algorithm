import java.util.*;

class Solution {
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean[][] visited;
    static int lr, lc;
    static int[][] map;
    
    public int solution(int[][] maps) {
        
        lr = maps.length;
        lc = maps[0].length;
        map = maps;
        visited = new boolean[lr][lc];
        int answer = bfs(0,0,1);
        return answer;
    }
    
    public int bfs(int r, int c, int dist) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r,c,dist});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cd = cur[2];
            
            if(cr == (lr-1) && cc == (lc-1)) {
                return cd;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr >= 0 && nr < lr && nc >= 0 && nc < lc && map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, cd+1});
                }
            }
        }
        return -1;
    }
}