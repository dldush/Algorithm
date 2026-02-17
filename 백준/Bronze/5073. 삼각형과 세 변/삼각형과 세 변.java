import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);

            int[] triangle = new int[3];

            for (int i = 0; i < 3; i++) {
                triangle[i] = Integer.parseInt(st.nextToken());
            }

            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) break;
            Arrays.sort(triangle);

            if (triangle[2] >= triangle[1] + triangle[0]) System.out.println("Invalid");

            else if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) System.out.println("Equilateral");

            else if (triangle[0] == triangle[1] || triangle[1] == triangle[2]) System.out.println("Isosceles");

            else System.out.println("Scalene");
        }

    }
}
