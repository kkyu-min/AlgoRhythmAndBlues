import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int g,p;
    static int answer;
    static int[] parents;
    static int[] airplanes;

    public static void makeSet(){
        for(int i=1;i<g+1;i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        g = parseInt(br.readLine());
        p = parseInt(br.readLine());

        parents = new int[g+1];
        airplanes = new int[p];

        for(int i=0;i<p;i++) {
            airplanes[i] = parseInt(br.readLine());
        }
        makeSet();

        for(int i=0;i<p;i++){
            int tmp = airplanes[i];
            if(findSet(tmp) == 0) break;
            else {
                answer++;
                union(findSet(tmp)-1, tmp);
            }

        }
        System.out.println(answer);
    }
}
