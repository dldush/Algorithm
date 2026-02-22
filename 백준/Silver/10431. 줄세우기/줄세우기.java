import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < P; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testId = Integer.parseInt(st.nextToken());

            int[] line = new int[20];
            int moves = 0;

            // i번째 학생을 "정렬된 앞부분"에 삽입
            for (int i = 0; i < 20; i++) {
                int x = Integer.parseInt(st.nextToken());

                // line[0..i-1] 은 정렬되어 있다고 가정하고, x를 끼워 넣는다.
                int j = i - 1;
                while (j >= 0 && line[j] > x) {
                    line[j + 1] = line[j]; // 한 칸 뒤로 밀기
                    moves++;               // 이동 1회 발생
                    j--;
                }
                line[j + 1] = x; // x 삽입
            }

            sb.append(testId).append(" ").append(moves).append("\n");
        }

        System.out.print(sb.toString());
    }
}