import java.util.*;

public class Solution {
    public int solution(int n) {
        int num = n;
        int answer = 0;
        
        while(true) {
            answer += num % 10;
            num /= 10;
            
            if (num == 0) break;
        } 


        return answer;
    }
}