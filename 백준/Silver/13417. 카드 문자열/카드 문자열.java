import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            for (int n = 0; n < N; n++) {
                char cur = sc.next().charAt(0);
                if (sb.length() == 0) {
                    sb.append(cur);
                } else {
                    if (sb.charAt(0) >= cur) {
                        sb.insert(0, cur);
                    } else {
                        sb.append(cur);
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
