import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;

    static void bfs() {
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>((o1,o2) -> o1.size() - o2.size());
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(N);
        queue.add(tmp);

        while(!queue.isEmpty()) {
            ArrayList<Integer> arr = queue.poll();
            int last = arr.get(arr.size()-1);

            if(last==1) {
                System.out.println(arr.size()-1);
                for(int i=0;i<arr.size();i++){
                    System.out.print(arr.get(i) + " ");
                }
                break;
            }
            if(last%3==0) {
                ArrayList<Integer> arr3 = new ArrayList<>(arr);
                arr3.add(last/3);
                queue.add(arr3);
            }
            if(last%2==0) {
                ArrayList<Integer> arr2 = new ArrayList<>(arr);
                arr2.add(last/2);
                queue.add(arr2);
            }
            arr.add(last-1);
            queue.add(arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        bfs();
    }
}
