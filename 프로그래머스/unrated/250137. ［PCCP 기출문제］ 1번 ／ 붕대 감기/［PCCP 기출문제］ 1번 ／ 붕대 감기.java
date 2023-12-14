class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int cnt = 0; // 공격횟수
        int time = 0; // 시간
        int continueAttack = 0; // 연속 공격 횟수
        int originHealth = health;
        while(cnt < attacks.length){
            time++;
            // 공격받는지 검사
            if(attacks[cnt][0] == time) {
                continueAttack=0;
                health -= attacks[cnt][1];
                if(health<=0) {
                    health = -1;
                    break;
                }
                cnt++;
            }
            else {
                // 공격받지 않음
                health+=bandage[1];
                continueAttack++;
                if(continueAttack == bandage[0]) {
                    continueAttack=0;
                    health+=bandage[2];
                }
                if(health>originHealth){
                    health = originHealth;
                }
            }
            System.out.println(health);
        }
        return health;
    }
}