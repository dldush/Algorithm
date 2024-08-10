import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();

			int[] building = new int[N];
			for (int i = 0; i < N; i++) {
				building[i] = sc.nextInt();
			}
			int answer = 0;
			int left = 0;
			int right = 0;

			for (int i = 2; i < N - 2; i++) {
				if (building[i] > building[i - 2] && building[i] > building[i - 1] && building[i] > building[i + 1]
						&& building[i] > building[i + 2]) {
					left = Math.min(building[i] - building[i - 2], building[i] - building[i - 1]);
					right = Math.min(building[i] - building[i + 1], building[i] - building[i + 2]);

					answer += Math.min(left, right);
				}
			}

			System.out.println("#" + tc + " " + answer);

		} // tc end

	}
}