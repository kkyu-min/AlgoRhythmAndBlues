class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] child = new int[n+2]; // 전체 학생에 대한 체육복 정보 0 없음 1 한개 2 두개
        for(int i=1;i<n+1;i++){
            child[i] = 1;
        }
        for(int i=0;i<reserve.length;i++){
            child[reserve[i]]+=1;
        }
        for(int i=0;i<lost.length;i++){
            child[lost[i]]-=1;
        }
        for(int i=1;i<n+1;i++){
            System.out.println(child[i]);
        }
        
        for(int i=1;i<n+1;i++){
            if(child[i]==0) { // 체육복 없는 경우 => 빌려야함 => 앞 뒤 번호 확인
                if(child[i-1]==2){
                    child[i]+=1;
                    child[i-1]-=1;
                }
                else if(child[i+1]==2){
                    child[i]+=1;
                    child[i+1]-=1;
                }
                
            }
        }
        for(int i=1;i<n+1;i++){
            if(child[i]>=1) answer++;
        }
        return answer;
    }
}