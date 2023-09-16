class Solution {
    static int userCount;
    static int emoCount;
    static int[] discount;
    static int[] answer;
    static int tc;
    
    public static void comb(int cnt, int users[][], int emoticons[]) {
        if(cnt == emoCount) {
            // 점수 계산
            // 인당 이모티콘 계산량 계산 후 분류
            int[] tmp = new int[2];
            for(int i=0;i<userCount;i++) {
                int total = 0;
                for(int j=0;j<emoCount;j++){
                    if(discount[j]*10 >= users[i][0]){ // 물건 할인률> 원하는 할인률
                        total += emoticons[j] * (10-discount[j]) /10;
                    }
                }
                // 이모티콘 플러스 결제 할지 말지
                if(total >= users[i][1]) {
                    tmp[0]++;
                }
                else {
                    tmp[1] += total;
                }
            }
            // answer 와 비교
            if(answer[0] < tmp[0]){
                answer[0] = tmp[0];
                answer[1] = tmp[1];
            }
            else if(answer[0] == tmp[0]) {
                if(answer[1] <= tmp[1]) {
                    answer[1] = tmp[1];
                }
            }
            return;
        }
        for(int i=1;i<=4;i++) {
            discount[cnt] = i;
            comb(cnt+1, users, emoticons);
            
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        userCount = users.length;
        emoCount = emoticons.length;
        
        discount = new int[emoCount];

        comb(0,users,emoticons);
      
        return answer;
    }
}