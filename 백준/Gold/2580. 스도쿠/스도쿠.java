import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int[][] sudoku = new int[9][9];
    static int[][] arr = new int[9][9];
    static ArrayList<int[]> zero = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean first;

    static void recur(int cur) {
        if(cur == zero.size()) {
            if(!first) {
                first=true;
                for(int i=0;i<9;i++) {
                    for(int j=0;j<9;j++) {
                        sb.append(sudoku[i][j]).append(" ");
                    }
                    sb.append("\n");
                }
            }
            return;
        }
        int x = zero.get(cur)[0];
        int y = zero.get(cur)[1];

        for(int i=1;i<10;i++) {
            if(check(x,y,i)) {
                sudoku[x][y]=i;
                recur(cur+1);
            }
        }
        sudoku[x][y] =0;
    }

    static boolean check(int x, int y, int num) {
        // 가로 확인
        for(int i=0;i<9;i++) {
            if(sudoku[x][i]== num) return false;
        }
        // 세로 확인
        for(int i=0;i<9;i++){
            if(sudoku[i][y]==num) return false;
        }
        // 정사각형 확인
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(sudoku[(x/3)*3 + i][(y/3)*3 + j] == num) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<9;j++) {
                sudoku[i][j] = Integer.parseInt(tmp[j]);
                if(sudoku[i][j] == 0) {
                    zero.add(new int[] {i,j});
                }
            }
        }

        recur(0);
        System.out.println(sb);
    }
}
