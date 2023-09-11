import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> arr; // key, value
    
    static void comb(String str, int depth, String[] info) {
        if(depth==4) {
            if(arr.containsKey(str)){
                arr.get(str).add(Integer.parseInt(info[4]));
            }
            else {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(Integer.parseInt(info[4]));
                arr.put(str, tmp);
            }
            return;
        }
        
        comb(str+"-", depth+1, info);
        comb(str+info[depth], depth+1, info);
    }
    static int binary(String query){
        String[] sen = query.split(" and ");
        String check = sen[0] + sen[1] + sen[2] + sen[3].split(" ")[0];
        int score = Integer.parseInt(sen[3].split(" ")[1]);
        
        if(!arr.containsKey(check)) return 0;
        
        // 점수 이분탐색
        ArrayList<Integer> scores = arr.get(check);
        
        int start = 0;
        int end = scores.size()-1;
        
        while(start<=end) {
            int mid = (start + end) / 2;
            
            if(scores.get(mid)<score) {
                start = mid +1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return scores.size() - start;
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        arr = new HashMap<>();
        
        for(int i=0;i<info.length;i++) { // 모든 경우 저장
            comb("",0,info[i].split(" "));
        }
        Set<String> set = arr.keySet();
        for(String tmp: set) {
            // 각 경우별 가능한 점수
            // 오름 차순 정렬
            Collections.sort(arr.get(tmp)); 
        }
        
        for(int i=0;i<query.length;i++) {
            answer[i] = binary(query[i]);
        }
        return answer;
    }
}