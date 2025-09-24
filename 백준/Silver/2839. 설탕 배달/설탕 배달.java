import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int ans = 0;

        while (target > 0) {
            if (target % 5 == 0) {
                ans += target / 5;
                break;
            }
            else {
                target -= 3;
                ans++;
            }
        }
        if (target < 0) System.out.println(-1);
        else System.out.println(ans);
    }
}
