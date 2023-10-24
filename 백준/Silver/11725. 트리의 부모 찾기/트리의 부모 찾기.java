import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N+1;i++) {
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++){
            String[] tmp = br.readLine().split(" ");
            arr.get(Integer.parseInt(tmp[0])).add(Integer.parseInt(tmp[1]));
            arr.get(Integer.parseInt(tmp[1])).add(Integer.parseInt(tmp[0]));
        }

        boolean[] checked = new boolean[N+1];
        int[] answer = new int[N+1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        checked[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<arr.get(now).size();i++) {
                if(!checked[arr.get(now).get(i)]) {
                    queue.add(arr.get(now).get(i));
                    checked[arr.get(now).get(i)] = true;
                    answer[arr.get(now).get(i)] = now;
                }
            }
        }

        for(int i=2;i<N+1;i++){
            System.out.println(answer[i]);
        }

    }
}
