import java.util.*;

class Solution {
    static HashSet<HashSet<String>> result = new HashSet<>();
    static void dfs(HashSet<String> set, int depth, String[] user_id, String[] banned_id) {
        if(depth == banned_id.length) {
            result.add(set);
            return;
        }
        
        for(int i=0;i<user_id.length;i++) {
            if(set.contains(user_id[i])) {
                continue;
            }
            if(check(user_id[i], banned_id[depth])) {
                set.add(user_id[i]);
                dfs(new HashSet<>(set), depth+1, user_id, banned_id);
                set.remove(user_id[i]);
            }
        }
    }
    
    static boolean check(String userId, String bannedId) {
        if(userId.length() != bannedId.length()){
            return false;
        }
        boolean res = true;
        
        for(int i=0;i<userId.length();i++) {
            if(userId.charAt(i) != bannedId.charAt(i) && bannedId.charAt(i)!='*') {
                res = false;
                break;
            }
        }
        
        return res;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        dfs(new HashSet<>(), 0, user_id, banned_id);
        return result.size();
    }
}