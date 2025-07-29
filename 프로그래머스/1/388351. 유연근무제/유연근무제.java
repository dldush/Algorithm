import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int limit = getLimit(schedules[i]);
            int day = startday;
            
            for(int j = 0; j < timelogs[i].length; j++) {
                
                if(day % 7 == 6 || day % 7 == 0) {
                    day++;
                    continue;
                }
                
                if(timelogs[i][j] > limit) {
                    break;
                }
                
                day++;
            }
            if(day == startday + 7) {
                answer++;            
            }
        }
        
        return answer;
    }
    
    public int getLimit(int schedules) {
        int limit = schedules + 10;
        int h = (limit / 100);
        int m = (limit % 100);
        
        if(m >= 60) {
            h += 1;
            m -= 60;
        }
        return (h * 100) + m;
    }
}