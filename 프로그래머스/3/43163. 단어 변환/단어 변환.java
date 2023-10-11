import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] visited;
    public void dfs(String str, String target, String[] words, int count) {
        if(str.equals(target)){
            answer = count;
            return;
        }
        for(int i=0;i<words.length;i++) {
            if(!visited[i] && check(str, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
    public boolean check(String str1, String str2) {
        int count = 0;
        
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        
        if(count == 1){
            return true;
        }
        else {
            return false;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
}