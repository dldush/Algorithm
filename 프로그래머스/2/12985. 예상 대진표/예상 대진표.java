class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int tmp = 0;
        if(a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        outer: while(true) {
            // 만났는지 체크
            if(a % 2 == 1 && a + 1 == b) {
                break outer;
            } 
            
            if(a % 2 == 1) {
                a = (a + 1) / 2;
            } else {
                a /= 2;
            }
            
            if(b % 2 == 1) {
                b = (b + 1) / 2;
            } else {
                b /= 2;
            }
            
            
            answer++;
            
        }
        
        return answer;
    }

}