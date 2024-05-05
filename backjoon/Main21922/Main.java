package backjoon.Main21922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] arr;
    static ArrayList<Pair> list;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        /*
            1은 ㅣ 1,3 넘어가, 0,2 멈춰
            2은 ㅡ 0,2 넘어가 1,3 멍춰
            3는 /  0 -> 3 , 1 -> 2 , 2 -> 1 , 3 -> 0
            4는 \  0 -> 1 , 1 -> 0 , 2 -> 3 , 3-> 2
            9 means air conditioner
            start at 22 12
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<Pair>();
        arr = new int[N][M];

        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==9)list.add(new Pair(i,j));
            }
        }

        if(list.size()==0) System.out.println(0);
        else{
            System.out.println(w_move());

        }
    }

    private static int w_move() {
        boolean[][] check = new boolean[N][M];

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int cnt = 0;
        for(Pair cur : list){
            check[cur.x][cur.y]=true;
            for (int i = 0; i < 4; i++) {
                int dir = i;
                int nx = cur.x;
                int ny = cur.y;
                while(true){
                    nx+=dx[dir];
                    ny+=dy[dir];
                    if(nx<0||ny<0||nx>N-1||ny>M-1)break;
                    if(arr[nx][ny]==1){
                        if(dir==0||dir==2){
                            if(!check[nx][ny])cnt++;
                            check[nx][ny]=true;
                            break;
                        }
                    }
                    else if(arr[nx][ny]==2){
                        if(dir==1||dir==3){
                            if(!check[nx][ny])cnt++;
                            check[nx][ny]=true;
                            break;
                        }
                    }
                    else if(arr[nx][ny]==3){
                        if(dir==0)dir=3;
                        else if(dir==1)dir=2;
                        else if(dir==2)dir=1;
                        else dir=0;
                    }
                    else if(arr[nx][ny]==4){
                        if(dir==0)dir=1;
                        else if(dir==1)dir=0;
                        else if(dir==2)dir=3;
                        else dir=2;
                    }
                    else if(nx==cur.x&&ny==cur.y){
                        break;
                    }
                    else if(arr[nx][ny]==9)break;
                    if(!check[nx][ny]&&arr[nx][ny]!=9)cnt++;
                    check[nx][ny]=true;
                }
            }
        }

        return cnt+list.size();
    }

}
