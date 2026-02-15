import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int rows = (H + (N + 1) - 1) / (N + 1); // ceil(H / (N+1))
        int cols = (W + (M + 1) - 1) / (M + 1); // ceil(W / (M+1))

        System.out.println(rows * cols);
    }
}