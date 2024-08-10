import java.util.Scanner;

public class Solution { // Flatten

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();

			int[] arr = new int[100];

			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			int answer = 0;

			for (int i = 0; i < N; i++) {

				int max = 0;
				int min = 100;

				int idx1 = 0;
				int idx2 = 0;

				for (int j = 0; j < 100; j++) {
					if (arr[j] >= max) {
						max = arr[j];
						idx1 = j;
					}
					if (arr[j] <= min) {
						min = arr[j];
						idx2 = j;
					}
				}

				arr[idx1] = arr[idx1] - 1;
				arr[idx2] = arr[idx2] + 1;
				
				max = 0;
				min = 100;
				
				for(int j = 0 ; j < 100 ; j++) {
					if (arr[j] >= max) {
						max = arr[j];
						idx1 = j;
					}
					if (arr[j] <= min) {
						min = arr[j];
						idx2 = j;
					}
				}

				answer = max - min;

			}

			System.out.println("#" + tc + " " + answer);
		}

	} // tc end
}
