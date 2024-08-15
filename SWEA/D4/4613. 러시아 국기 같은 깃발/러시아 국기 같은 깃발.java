import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			String[][] flag = new String[N][M];
			
			for(int n = 0 ; n < N ; n++) {
				String str = sc.next();
				for(int m = 0 ; m < M ; m++) {
					flag[n][m] = String.valueOf(str.charAt(m));
				}
			}
			

			int[][] count = new int[N][3];

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (flag[n][m].equals("W")) {
						count[n][0]++;
					} else if (flag[n][m].equals("B")) {
						count[n][1]++;
					} else if (flag[n][m].equals("R")) {
						count[n][2]++;
					}
				}
			}
			int answer = Integer.MAX_VALUE;

			for (int wRow = 0; wRow < N - 2; wRow++) {
				for (int bRow = wRow + 1; bRow < N - 1; bRow++) {
					int rRow = N - 1;
					int changes = 0;

					for (int i = 0; i <= wRow; i++) {
						changes += M - count[i][0];
					}
					for (int i = wRow + 1; i <= bRow; i++) {
						changes += M - count[i][1];
					}
					for (int i = bRow+1; i <= rRow ; i++) {
						changes += M - count[i][2];
					}
					answer = Math.min(changes, answer);
				}
			}
			System.out.println("#"+tc+" "+answer);
		} // tc end
		
	}

}
