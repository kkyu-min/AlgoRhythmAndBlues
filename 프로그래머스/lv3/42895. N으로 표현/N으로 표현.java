import java.util.*;
import java.lang.*;

class Solution {
    public void calc(HashSet<Integer> next, HashSet<Integer> a, HashSet<Integer> b) {
        for(int anum : a) {
            for(int bnum : b) {
                next.add(anum + bnum);
                next.add(anum * bnum);
                next.add(anum - bnum);
                if(bnum != 0) {
                    next.add(anum / bnum);
                }
            }
        }
    }
    public int makeNN(int num, int i) {
        String tmp = Integer.toString(num);
        String str = tmp.repeat(i);
        return Integer.parseInt(str);
    }
    
    public int solution(int N, int number) {
        int answer = 0;
        List<HashSet<Integer>> set = new ArrayList<>();
        // set 초기화
        for(int i=0;i<9;i++) {
            set.add(new HashSet<Integer>());
        }
        
        set.get(1).add(N);
        
        if(N == number) return 1;
        // 2개를 사용한 경우부터 순서대로 채워주기
        for(int i=2;i<9;i++){
            for(int j=1;j<=i-1;j++){
                calc(set.get(i), set.get(j), set.get(i-j));
            }
            set.get(i).add(makeNN(N, i));
        
            for(int num : set.get(i)) {
                if(num == number) return i;
            }
        }
        return -1;
    }
}