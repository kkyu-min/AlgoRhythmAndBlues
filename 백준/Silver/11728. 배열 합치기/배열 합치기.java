import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr1[i] = Integer.parseInt(tmp[i]);
        }

        tmp = br.readLine().split(" ");
        for(int i=0;i<m;i++) {
            arr2[i] = Integer.parseInt(tmp[i]);
        }

        int index1 = 0;
        int index2 = 0;
        while(index1<n || index2<m) {
            if(index1 >= n) {
                sb.append(arr2[index2]).append(" ");
                index2++;
            }
            else if(index2 >= m) {
                sb.append(arr1[index1]).append(" ");
                index1++;
            }
            else {
                if(arr1[index1] <= arr2[index2]) {
                    sb.append(arr1[index1]).append(" ");
                    index1++;
                }
                else{
                    sb.append(arr2[index2]).append(" ");
                    index2++;
                }
            }
        }
        System.out.println(sb);
    }
}
