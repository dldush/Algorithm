import java.util.Scanner;

public class Solution {

    // + delta
    static int[] dr1 = { -1, 0, 1, 0 };
    static int[] dc1 = { 0, 1, 0, -1 };

    // x delta
    static int[] dr2 = { -1, -1, 1, 1 };
    static int[] dc2 = { -1, 1, 1, -1 };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt(); // scale
            int M = sc.nextInt(); // power

            int[][] arr = new int[N][N]; // array initiate

            // input array
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }

            int max = 0;

            // + sum 계산
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int tsum = arr[r][c];  // 중심 파리
                    for (int dir = 0; dir < 4; dir++) {
                        for (int i = 1; i < M; i++) {
                            int nr1 = r + dr1[dir] * i;
                            int nc1 = c + dc1[dir] * i;
                            if (nr1 >= 0 && nr1 < N && nc1 >= 0 && nc1 < N) {
                                tsum += arr[nr1][nc1];
                            }
                        }
                    }
                    max = Math.max(max, tsum);
                }
            }

            // x sum 계산
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int xsum = arr[r][c];  // 중심 파리
                    for (int dir = 0; dir < 4; dir++) {
                        for (int i = 1; i < M; i++) {
                            int nr2 = r + dr2[dir] * i;
                            int nc2 = c + dc2[dir] * i;
                            if (nr2 >= 0 && nr2 < N && nc2 >= 0 && nc2 < N) {
                                xsum += arr[nr2][nc2];
                            }
                        }
                    }
                    max = Math.max(max, xsum);
                }
            }

            System.out.println("#" + tc + " " + max);
        } // tc end
    }
}
