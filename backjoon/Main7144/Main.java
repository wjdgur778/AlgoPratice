package backjoon.Main7144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int n;
    static int num;
    static int ax;
    static int ay;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int s_x = (N/2)-1;
        int s_y = N/2;
        ax = N/2;
        ay = N/2;
        arr[N/2][N/2]=1;
        n=2;
        for (int i = 3; i <=N ; i+=2) {
            calc(i,s_x--,s_y--);
            n++;
        }
        for (int i = 0; i < N; i++) {
            StringBuilder sb =new StringBuilder();
            for (int j = 0; j <N ; j++) {
                if(j!=N-1)
                    sb.append(arr[i][j]).append(" ");
                else sb.append(arr[i][j]);
            }
            System.out.println(sb.toString());
        }

        System.out.println((ax+1)+" "+(ay+1));
    }
    public static void calc(int max,int x,int y){
        //오른쪽으로 max-2번
        //아래로 max -1번
        //왼쪽으로 max -1번
        //위로 max -1번
        for (int i = 0; i < max-2; i++) {
            arr[x][y]=n;
            if(num==n){
                ax=x;ay=y;
            }
            n++;
            y++;
        } for (int i = 0; i < max-1; i++) {
            arr[x][y]=n;
            if(num==n){
                ax=x;ay=y;
            }
            x++;
            n++;
        } for (int i = 0; i < max-1; i++) {
            arr[x][y]=n;
            if(num==n){
                ax=x;ay=y;
            }
            y--;
            n++;
        } for (int i = 0; i < max-1; i++) {
            arr[x][y]=n;
            if(num==n){
                ax=x;ay=y;
            }
            x--;
            n++;
        }
        if(num==n){
            ax=x;ay=y;
        }
        arr[x][y]=n;
    }
}
