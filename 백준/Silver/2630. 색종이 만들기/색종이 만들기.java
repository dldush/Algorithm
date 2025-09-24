import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white, blue;

    static boolean checkP(int r, int c, int size, int[][] paper) {
        int color = paper[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != color) return false;
            }
        }
        return true;
    }

    static void cutP(int r, int c, int size, int[][] paper) {
        if (checkP(r, c, size, paper)) {
            if (paper[r][c] == 0) white++;
            else blue ++;
            return;
        }

        int half = size / 2;
        cutP(r, c, half, paper);
        cutP(r + half, c, half, paper);
        cutP(r, c + half, half, paper);
        cutP(r + half, c + half, half, paper);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cutP(0, 0, N, paper);

        System.out.println(white);
        System.out.println(blue);
    }
}
