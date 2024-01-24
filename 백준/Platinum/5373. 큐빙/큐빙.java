import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {
    
    static char[][] up = new char[3][3];
    static char[][] down = new char[3][3];
    static char[][] front = new char[3][3];
    static char[][] back = new char[3][3];
    static char[][] left = new char[3][3];
    static char[][] right = new char[3][3];
    
    static void reset() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                up[i][j] = 'w';
            }
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                down[i][j] = 'y';
            }
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                front[i][j] = 'r';
            }
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                back[i][j] = 'o';
            }
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                left[i][j] = 'g';
            }
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                right[i][j] = 'b';
            }
        }
    }
    
    static void rotateup(char dir) {
        if(dir=='+') { // 시계방향
            char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = up[i][j];
            	}
            }
            
            // 해당 판 돌리기
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    up[i][j] = tmp[2-j][i];
                }
            }
            // 옆 라인 돌리기
            char[] ftmp = front[0].clone();
            char[] ltmp = left[0].clone();
            char[] btmp = back[0].clone();
            char[] rtmp = right[0].clone();
            
            for(int i=0;i<3;i++) {
                front[0][i]=rtmp[i];
            }
            for(int i=0;i<3;i++) {
                left[0][i]=ftmp[i];
            }
            for(int i=0;i<3;i++) {
                back[0][i]=ltmp[i];
            }
            for(int i=0;i<3;i++) {
                right[0][i]=btmp[i];
            }
        }
        else { // 반시계 방향
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = up[i][j];
            	}
            }
            // 해당 판 돌리기
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    up[i][j]=tmp[j][2-i];
                }
            }
            // 옆라인 돌리기
            char[] ftmp = front[0].clone();
            char[] ltmp = left[0].clone();
            char[] btmp = back[0].clone();
            char[] rtmp = right[0].clone();
            
            for(int i=0;i<3;i++) {
                right[0][i]=ftmp[i];
            }
            for(int i=0;i<3;i++) {
                front[0][i]=ltmp[i];
            }
            for(int i=0;i<3;i++) {
                left[0][i]=btmp[i];
            }
            for(int i=0;i<3;i++) {
                back[0][i]=rtmp[i];
            }
        }
        
    }
    static void rotatedown(char dir) {
        if(dir=='+') {// 시계방향
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = down[i][j];
            	}
            }
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    down[i][j] = tmp[2-j][i];
                }
            }
            // 옆라인 돌리기
            char[] ftmp = front[2].clone();
            char[] ltmp = left[2].clone();
            char[] btmp = back[2].clone();
            char[] rtmp = right[2].clone();
            
            for(int i=0;i<3;i++) {
                front[2][i]=ltmp[i];
            }
            for(int i=0;i<3;i++) {
                left[2][i]=btmp[i];
            }
            for(int i=0;i<3;i++) {
                back[2][i]=rtmp[i];
            }
            for(int i=0;i<3;i++) {
                right[2][i]=ftmp[i];
            }
        }
        else { // 반시계방향
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = down[i][j];
            	}
            }
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    down[i][j] = tmp[j][2-i];
                }
            }
            // 옆라인 돌리기
            char[] ftmp = front[2].clone();
            char[] ltmp = left[2].clone();
            char[] btmp = back[2].clone();
            char[] rtmp = right[2].clone();
            
            for(int i=0;i<3;i++) {
                front[2][i]=rtmp[i];
            }
            for(int i=0;i<3;i++) {
                left[2][i]=ftmp[i];
            }
            for(int i=0;i<3;i++) {
                back[2][i]=ltmp[i];
            }
            for(int i=0;i<3;i++) {
                right[2][i]=btmp[i];
            }

        }    
    }
    static void rotatefront(char dir) {
        if(dir=='+') {
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = front[i][j];
            	}
            }
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    front[i][j] = tmp[2-j][i];
                }
            }
            char[] utmp = up[2].clone();
            char[] rtmp = new char[] {right[0][0],right[1][0],right[2][0]};
            char[] dtmp = down[2].clone();
            char[] ltmp = new char[] {left[0][2],left[1][2],left[2][2]};
            for(int i=0;i<3;i++) {
                up[2][i] = ltmp[2-i];
            }
            for(int i=0;i<3;i++) {
                right[i][0] = utmp[i];
            }
            for(int i=0;i<3;i++){
                down[2][i]= rtmp[i];
            }
            for(int i=0;i<3;i++) {
                left[i][2] = dtmp[2-i];
            }
        }
        else {
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = front[i][j];
            	}
            }
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		front[i][j]= tmp[j][2-i];
            	}
            }
            char[] utmp = up[2].clone();
            char[] rtmp = new char[] {right[0][0],right[1][0],right[2][0]};
            char[] dtmp = down[2].clone();
            char[] ltmp = new char[] {left[0][2],left[1][2],left[2][2]};
            for(int i=0;i<3;i++) {
            	up[2][i] = rtmp[i];
            }
            for(int i=0;i<3;i++) {
            	left[i][2] = utmp[2-i];
            }
            for(int i=0;i<3;i++) {
            	down[2][i] = ltmp[2-i];
            }
            for(int i=0;i<3;i++) {
            	right[i][0] = dtmp[i];
            }
        }
    }
    static void rotateback(char dir) {
        if(dir=='+') {
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = back[i][j];
            	}
            }
        	for(int i=0;i<3;i++) {
        		for(int j=0;j<3;j++) {
        			back[i][j] = tmp[2-j][i];
        		}
        	}
            char[] utmp = up[0].clone();
            char[] rtmp = new char[] {right[0][2], right[1][2], right[2][2]};
            char[] dtmp = down[0].clone();
            char[] ltmp = new char[] {left[0][0], left[1][0], left[2][0]};
            for(int i=0;i<3;i++) {
            	up[0][i] = rtmp[i];
            }
            for(int i=0;i<3;i++) {
            	left[i][0] = utmp[2-i];
            }
            for(int i=0;i<3;i++) {
            	down[0][i] = ltmp[2-i];
            }
            for(int i=0;i<3;i++) {
            	right[i][2] = dtmp[i];
            }
        }
        else {
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = back[i][j];
            	}
            }
        	for(int i=0;i<3;i++) {
        		for(int j=0;j<3;j++) {
        			back[i][j] = tmp[j][2-i];
        		}
        	}
        	char[] utmp = up[0].clone();
            char[] rtmp = new char[] {right[0][2], right[1][2], right[2][2]};
            char[] dtmp = down[0].clone();
            char[] ltmp = new char[] {left[0][0], left[1][0], left[2][0]};
            for(int i=0;i<3;i++) {
            	up[0][i] = ltmp[2-i];
            }
            for(int i=0;i<3;i++) {
            	left[i][0] = dtmp[2-i];
            }
            for(int i=0;i<3;i++) {
            	down[0][i] = rtmp[i];
            }
            for(int i=0;i<3;i++) {
            	right[i][2] = utmp[i];
            }
        }    
    }
    static void rotateleft(char dir) {
        if(dir=='+') {
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = left[i][j];
            	}
            }
        	for(int i=0;i<3;i++) {
        		for(int j=0;j<3;j++) {
        			left[i][j] = tmp[2-j][i];
        		}
        	}
        	char[] utmp = new char[] {up[0][0], up[1][0], up[2][0]};
        	char[] ftmp = new char[] {front[0][0], front[1][0], front[2][0]};
        	char[] dtmp = new char[] {down[0][2], down[1][2], down[2][2]};
        	char[] btmp = new char[] {back[0][2], back[1][2], back[2][2]};
        	for(int i=0;i<3;i++) {
        		front[i][0] = utmp[i];
        	}
        	for(int i=0;i<3;i++) {
        		down[i][2] = ftmp[2-i];
        	}
        	for(int i=0;i<3;i++) {
        		back[i][2] = dtmp[i];
        	}
        	for(int i=0;i<3;i++) {
        		up[i][0] = btmp[2-i];
        	}
        	
        }
        else {
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = left[i][j];
            	}
            }
        	for(int i=0;i<3;i++) {
        		for(int j=0;j<3;j++) {
        			left[i][j] = tmp[j][2-i];
        		}
        	}
        	char[] utmp = new char[] {up[0][0], up[1][0], up[2][0]};
        	char[] ftmp = new char[] {front[0][0], front[1][0], front[2][0]};
        	char[] dtmp = new char[] {down[0][2], down[1][2], down[2][2]};
        	char[] btmp = new char[] {back[0][2], back[1][2], back[2][2]};
        	for(int i=0;i<3;i++) {
        		front[i][0] = dtmp[2-i];
        	}
        	for(int i=0;i<3;i++) {
        		down[i][2] = btmp[i];
        	}
        	for(int i=0;i<3;i++) {
        		back[i][2] = utmp[2-i];
        	}
        	for(int i=0;i<3;i++) {
        		up[i][0] = ftmp[i];
        	}
        }    
    }
    static void rotateright(char dir) {
        if(dir=='+') {
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = right[i][j];
            	}
            }
        	for(int i=0;i<3;i++) {
        		for(int j=0;j<3;j++) {
        			right[i][j] = tmp[2-j][i];
        		}
        	}
        	char[] utmp = new char[] {up[0][2], up[1][2], up[2][2]};
        	char[] ftmp = new char[] {front[0][2], front[1][2], front[2][2]};
        	char[] dtmp = new char[] {down[0][0], down[1][0], down[2][0]};
        	char[] btmp = new char[] {back[0][0], back[1][0], back[2][0]};
        	for(int i=0;i<3;i++) {
        		up[i][2] = ftmp[i];
        	}
        	for(int i=0;i<3;i++) {
        		back[i][0] = utmp[2-i]; 
        	}
        	for(int i=0;i<3;i++) {
        		down[i][0] = btmp[i];
        	}
        	for(int i=0;i<3;i++) {
        		front[i][2] = dtmp[2-i];
        	}
        }
        else {
        	char[][] tmp = new char[3][3];
            for(int i=0;i<3;i++) {
            	for(int j=0;j<3;j++) {
            		tmp[i][j] = right[i][j];
            	}
            }
        	for(int i=0;i<3;i++) {
        		for(int j=0;j<3;j++) {
        			right[i][j] = tmp[j][2-i];
        		}
        	}
        	char[] utmp = new char[] {up[0][2], up[1][2], up[2][2]};
        	char[] ftmp = new char[] {front[0][2], front[1][2], front[2][2]};
        	char[] dtmp = new char[] {down[0][0], down[1][0], down[2][0]};
        	char[] btmp = new char[] {back[0][0], back[1][0], back[2][0]};
        	for(int i=0;i<3;i++) {
        		up[i][2] = btmp[2-i];
        	}
        	for(int i=0;i<3;i++) {
        		back[i][0] = dtmp[i];
        	}
        	for(int i=0;i<3;i++) {
        		down[i][0] = ftmp[2-i];
        	}
        	for(int i=0;i<3;i++) {
        		front[i][2] = utmp[i];
        	}
        }
    }
    
    static void print() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(up[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = parseInt(br.readLine());
        
        for(int t=0;t<tc;t++) {
            reset();
            
            int num = parseInt(br.readLine());
            String[] tmp = br.readLine().split(" ");
            
            for(int i=0;i<num;i++) {
                if(tmp[i].charAt(0)=='U') {
                    rotateup(tmp[i].charAt(1));
                }
                else if(tmp[i].charAt(0)=='D') {
                    rotatedown(tmp[i].charAt(1));
                }
                else if(tmp[i].charAt(0)=='F') {
                    rotatefront(tmp[i].charAt(1));
                }
                else if(tmp[i].charAt(0)=='B') {
                    rotateback(tmp[i].charAt(1));
                }
                else if(tmp[i].charAt(0)=='L') {
                    rotateleft(tmp[i].charAt(1));
                }
                else if(tmp[i].charAt(0)=='R') {
                    rotateright(tmp[i].charAt(1));
                }
            }
            
            print();
        }
    }

}