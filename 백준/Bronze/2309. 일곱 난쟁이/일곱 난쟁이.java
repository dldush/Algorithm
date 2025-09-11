import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int sum = 0;

		outer: for (int a = 0; a < 3; a++) {
			for (int b = 1; b < 4; b++) {
				for (int c = 2; c < 5; c++) {
					for (int d = 3; d < 6; d++) {
						for (int e = 4; e < 7; e++) {
							for (int f = 5; f < 8; f++) {
								for (int g = 6; g < 9; g++) {
									{

										sum = arr[a] + arr[b] + arr[c] + arr[d] + arr[e] + arr[f] + arr[g];
										if (sum == 100) {
											System.out.println(arr[a]);
											System.out.println(arr[b]);
											System.out.println(arr[c]);
											System.out.println(arr[d]);
											System.out.println(arr[e]);
											System.out.println(arr[f]);
											System.out.println(arr[g]);
											break outer;
										}
										sum = 0;
									}
								}
							}
						}
					}
				}
			}
		}

	} // main end

}
