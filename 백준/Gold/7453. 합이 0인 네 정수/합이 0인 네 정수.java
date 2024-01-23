import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            a[i] = Integer.parseInt(tmp[0]);
            b[i] = Integer.parseInt(tmp[1]);
            c[i] = Integer.parseInt(tmp[2]);
            d[i] = Integer.parseInt(tmp[3]);
        }

        int[] ab = new int[n*n];
        int[] cd = new int[n*n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                ab[n*i +j] = a[i] + b[j];
                cd[n*i +j] = c[i] + d[j];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long answer = 0;
        int abIndex=0;
        int cdIndex=n*n-1;

        while(abIndex<n*n && cdIndex>=0) {
            if(ab[abIndex] + cd[cdIndex] == 0){
                // 중복 된 경우 생각
                long abNum = 0;
                long cdNum = 0;
                int abNow = ab[abIndex];
                int cdNow = cd[cdIndex];
                while(abIndex<n*n && abNow==ab[abIndex]){
                    abIndex++;
                    abNum++;
                }
                while(cdIndex>=0 && cdNow==cd[cdIndex]) {
                    cdIndex--;
                    cdNum++;
                }
                answer+=abNum * cdNum;
            }
            else if(ab[abIndex] + cd[cdIndex] < 0) {
                abIndex++;
            }
            else {
                cdIndex--;
            }
        }

        System.out.println(answer);
    }
}
