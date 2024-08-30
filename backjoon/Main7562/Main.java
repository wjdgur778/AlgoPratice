package backjoon.Main7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int T;
    static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st  = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Pair start = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Pair end = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            int[][] arr = new int[N][N];

            System.out.println(bfs(start,end,arr));

        }

    }

    public static int bfs(Pair start, Pair end,int[][] arr){
        int cnt = 0;
        boolean[][]  check = new boolean[N][N];
        Queue<Pair>q = new LinkedList<Pair>();
        q.offer(start);

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i <size ; i++) {
                Pair cur = q.poll();
                if(end.x==cur.x&&end.y==cur.y)return cnt;
                for (int j = 0; j <8 ; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx<0||ny<0||nx>N-1||ny>N-1)continue;
                    if(check[nx][ny])continue;
                    q.offer(new Pair(nx,ny));
                    check[nx][ny]=true;
                }
            }
            cnt++;
        }

        return cnt;
    }
}
