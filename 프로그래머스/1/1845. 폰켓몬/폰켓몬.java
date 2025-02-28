import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int numLength = nums.length;
        HashMap<Integer, Integer> numMap = new HashMap<>();
        
        for(int i = 0; i < numLength; i++) {
            numMap.put(nums[i], i);
        }
        int total = numMap.size();
        int pick = numLength/2;
        int answer = 0;
        if(pick < total) {
            answer = pick;
        } else {
            answer = total;
        }
        
        return answer;
    }
}