import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // Pattern Length

			char[][] arr = new char[8][8]; // char map

			// array input
			for (int i = 0; i < 8; i++) {
				arr[i] = sc.next().toCharArray();
			}

			int answer = 0;

			// searching for row
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c <= 8 - N; c++) { // searching row
					boolean isPalindrome = true;
					for (int i = 0; i < N / 2; i++) { // checking palindrome
						if (arr[r][c + i] != arr[r][c + (N - 1) - i]) {
							isPalindrome = false;
						}

					}
					if (isPalindrome) {
						answer++;
					}
				}
			} // search end

			// searching for column
			for (int c = 0; c < 8; c++) {
				for (int r = 0; r <= 8 - N; r++) { // searching column
					boolean isPalindrome = true;
					for (int i = 0; i < N / 2; i++) { // checking palindrome
						if (arr[r + i][c] != arr[r + (N - 1) - i][c]) {
							isPalindrome = false;
						}

					}
					if (isPalindrome) {
						answer++;
					}
				}
			} // search end
			System.out.println("#" + tc + " " + answer);
		} // tc end

	}
}
