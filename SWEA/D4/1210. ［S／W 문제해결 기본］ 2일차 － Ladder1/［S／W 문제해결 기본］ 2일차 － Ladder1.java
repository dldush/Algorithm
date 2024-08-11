import java.util.Scanner;

public class Solution { // ladder

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int T = sc.nextInt();

			int[][] ladder = new int[100][100];

			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					ladder[r][c] = sc.nextInt();
				}
			}

			int idxr = 99;
			int idxc = 0;

			// find 2's c
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) {
					idxc = i;
				}
			}

			for (int i = 99; i >= 0; i--) {
				// searching 1 for left
				if (idxc > 0 && ladder[i][idxc-1] == 1) {
					while (idxc > 0 && ladder[i][idxc-1] == 1) {
						idxc--;
					}
				// searching 1 for right
				} else if (idxc < 99 && ladder[i][idxc+1] == 1) {
					while (idxc < 99 && ladder[i][idxc+1] == 1) {
						idxc++;
					}
				}
			} // search end
			
			System.out.println("#"+T+" "+idxc);
			
		} // tc end
	}

}
