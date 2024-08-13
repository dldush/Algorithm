import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();

			LinkedList<Integer> arr = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				arr.add(sc.nextInt());
			}

			int K = sc.nextInt();

			for (int i = 0; i < K; i++) {
				if (sc.next().equals("I")) {
					int put = sc.nextInt();
					int n = sc.nextInt();
					for (int j = 0; j < n; j++) {
						arr.add(put, sc.nextInt());
						put++;
					}
				}
			}
			System.out.printf("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.printf(arr.get(i)+" ");
			}
			System.out.println();

		} // tc end
	}

}
