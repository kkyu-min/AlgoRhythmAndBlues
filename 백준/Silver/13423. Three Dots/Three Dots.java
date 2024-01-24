import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    //static HashSet<Integer> set;
    static int[] arr;

    private static boolean check(int start, int end) {
        if((arr[start]+arr[end])%2!=0) {
            return false;
        }

        int target = (arr[start]+arr[end])/2;
        while(start <= end) {
            int mid = (start+end)/2;

            if(target==arr[mid]) return true;
            else if(target < arr[mid]) end=mid-1;
            else start=mid+1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for(int t=0;t<test;t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];

            //set = new HashSet<>();
            String[] tmp = br.readLine().split(" ");
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(tmp[i]);
                //set.add(arr[i]);
            }
            Arrays.sort(arr);

            int cnt = 0;
            for(int i=0;i<n-2;i++){
                for(int j=i+2;j<n;j++) {
//                    if((arr[j]-arr[i])%2==0) {
//                        if(set.contains((arr[j]+arr[i])/2)) cnt++;
//                    }
                    if(check(i,j)) cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
