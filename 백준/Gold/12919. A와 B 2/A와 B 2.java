/**
 * A와 B 2 / 골드 5 / 
 * https://www.acmicpc.net/problem/12919
 */

import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {
	
	static String S;
	static String T;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();
		
		dfs(S,T);
		System.out.println(answer);

	}
	private static void dfs(String s, String t) {
		if(s.length()==t.length()) {
			if(s.equals(t)) {
				answer=1;
			}
			return;
		}
		if(t.charAt(0)=='B') { // 첫번째 문자 B인경우 빼고 뒤집음
			String sub = t.substring(1); // 첫번째 문자 제거
			StringBuilder sb = new StringBuilder(sub);
			String changed = sb.reverse().toString();
			dfs(s,changed);
		}
		if(t.charAt(t.length()-1)=='A') { // 마지막 문자 A인경우 A뺌
			dfs(s,t.substring(0,t.length()-1));
		}
	}

}
