import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            String name = clothes[i][0];
            String type = clothes[i][1];
            if(map.containsKey(type)) {
                HashSet<String> tmp = map.get(type);
                tmp.add(name);
            }
            else{
                HashSet<String> tmp = new HashSet<>();
                tmp.add(name);
                map.put(type,tmp);
            }
        }
        int tmp = 1;
        for(Map.Entry<String, HashSet<String>> entry: map.entrySet()) {
            String key = entry.getKey();
            HashSet<String> set = entry.getValue();
            tmp *= set.size()+1;
        }
        answer += tmp;
        answer -= 1;
        return answer;
    }
}