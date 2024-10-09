import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();
		int forth = sc.nextInt();
		int fifth = sc.nextInt();
		
		int answer = 0;
		
		answer = (int) (Math.pow(first, 2) + Math.pow(second, 2) + Math.pow(third, 2) + Math.pow(forth, 2) + Math.pow(fifth, 2)) % 10;
		
		System.out.println(answer);
	}

}