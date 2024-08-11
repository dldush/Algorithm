import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[100][100];

		for (int tc = 1; tc <= 10; tc++) {
			
			int T = sc.nextInt();
			
			for(int r = 0 ; r < 100 ; r++) {
				for(int c = 0 ; c < 100 ; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int rsum = 0;
			int rmax = 0;

			for (int r = 0; r < 100; r++) { // r hap
				rsum = 0;
				for (int c = 0; c < 100; c++) {
					rsum += arr[r][c];
				}
				rmax = Math.max(rmax, rsum);
			}

			int csum = 0;
			int cmax = 0;

			for (int c = 0; c < 100; c++) { // c hap
				csum = 0;
				for (int r = 0; r < 100; r++) {
					csum += arr[r][c];
				}
				cmax = Math.max(cmax, csum);
			}

			int d1sum = 0;

			for (int i = 0; i < 100; i++) { // diagonal 1 hap
				d1sum += arr[i][i];
			}

			int d2sum = 0;

			for (int i = 0; i < 100; i++) { // diagonal 2 hap
				d2sum += arr[i][99 - i];
			}

			int[] ans = {rmax, cmax, d1sum, d2sum};
			
			Arrays.sort(ans);
			
			System.out.println("#"+T+" "+ans[3]);
		} // tc end
	}

}
