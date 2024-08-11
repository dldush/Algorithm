import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			
			int T = sc.nextInt();
			
			String pattern = sc.next();
			String text = sc.next();
			
			int answer = 0;
			
			// searching
			for(int i = 0 ; i <= text.length() - pattern.length(); i++) {
				boolean isAnswer = true;
				for(int j = 0 ; j < pattern.length() ; j++) {
					if(text.charAt(i+j) != pattern.charAt(j)) {
						isAnswer = false;
					}
				}
				if(isAnswer) {
					answer++;
				}
			}
			System.out.println("#"+T+" "+answer);
			
		} // tc end
	}

}
