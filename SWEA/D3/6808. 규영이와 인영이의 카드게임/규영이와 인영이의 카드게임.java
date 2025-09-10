import java.util.Scanner;

public class Solution {
    static int winCnt, loseCnt;
    static int[] gCards, iCards;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            gCards = new int[9];
            for (int i = 0; i < 9; i++) gCards[i] = sc.nextInt();

            boolean[] has = new boolean[19];
            for (int v : gCards) has[v] = true;

            iCards = new int[9];
            int idx = 0;
            for (int v = 1; v <= 18; v++) if (!has[v]) iCards[idx++] = v;

            used = new boolean[9];
            winCnt = 0;
            loseCnt = 0;

            check(0, 0, 0);

            System.out.println("#" + tc + " " + winCnt + " " + loseCnt);
        }
    }

    static void check(int depth, int gScore, int iScore) {
        if (depth == 9) {
            if (gScore > iScore) winCnt++;
            else if (gScore < iScore) loseCnt++;
            return;
        }

        // permutation
        for (int j = 0; j < 9; j++) {
            if (used[j]) continue;
            used[j] = true;

            int sum = gCards[depth] + iCards[j];
            if (gCards[depth] > iCards[j]) {
                check(depth + 1, gScore + sum, iScore);
            } else {
                check(depth + 1, gScore, iScore + sum);
            }

            used[j] = false;
        }
    }
}
