class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(0, target, 0, numbers);
        return answer;
    }
    public int dfs(int index, int target, int sum, int[] numbers) {
        
        if(index == numbers.length){
            return (sum == target) ? 1 : 0;
        }
        
        return dfs(index + 1, target, sum + numbers[index], numbers) + dfs(index + 1, target, sum - numbers[index], numbers);
    }
}