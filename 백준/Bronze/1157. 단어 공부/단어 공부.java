import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);        
            count[ch - 'A']++;
        }

        int max = -1;
        char answer = '?';
        boolean duplicate = false;

        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) ('A' + i);
                duplicate = false; 
            } else if (count[i] == max) {
                duplicate = true;  
            }
        }

        System.out.println(duplicate ? "?" : String.valueOf(answer));
    }
}