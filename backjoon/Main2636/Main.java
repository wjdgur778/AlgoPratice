package backjoon.Main2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y =y ;
    }
}
public class Main {
    static int N, M;
    static boolean[][] check;
    static int[][] arr;
    static boolean stop = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        //init
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int pre = 0;
        int a = 3;
        while(true){
            int count = 0;
            check = new boolean[N][M];
            count+=bfs(0,0);
            if(count==0){
                System.out.println(time);
                System.out.println(pre);
                break;
            }
            time++;
            pre = count;
        }

    }
    public static int bfs(int x,int y){
        int sum =0 ;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(x,y));
        check[x][y]=true;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                for (int j = 0; j <4 ; j++) {
                    int nx = cur.x + dx[j];
                    int ny= cur.y + dy[j];
                    if(nx<0||ny<0||nx>N-1||ny>M-1)continue;
                    if(check[nx][ny])continue;
                    if(arr[nx][ny]==1){
                        arr[nx][ny]=0;
                        sum++;
                        check[nx][ny]=true;
                        continue;
                    }
                    check[nx][ny]=true;
                    q.offer(new Pair(nx,ny));
                }
            }
        }
        return sum;
    }
}
