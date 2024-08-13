import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			LinkedList<Integer> arr = new LinkedList<>();

			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				arr.add(sc.nextInt());
			}

			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				String x = sc.next();
				if (x.equals("I")) { // insert
					int idx = sc.nextInt();
					int n = sc.nextInt();
					for (int j = 0; j < n; j++) {
						arr.add(idx, sc.nextInt());
						idx++;
					}
				} // I end
				if (x.equals("D")) { // delete
					int idx = sc.nextInt();
					int n = sc.nextInt();
					for (int j = 0; j < n; j++) {
						arr.remove(idx);
					}

				} // D end

				if (x.equals("A")) { //
					int n = sc.nextInt();
					for (int j = 0; j < n; j++) {
						arr.add((arr.size() - 1), sc.nextInt());
					}
				} // A end

			}

			System.out.printf("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.printf(arr.get(i) + " ");
			}
			System.out.println();

		} // tc end

	}

}
