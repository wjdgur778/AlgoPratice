package backjoon.Main11123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int M;
    static char[][] arr;
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                for (int k = 0; k <M ; k++) {
                    arr[j][k] = str.charAt(k);
                }
            }
            boolean[][] check = new boolean[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k <M ; k++) {
                    if(check[j][k])continue;
                    if(arr[j][k]=='#'){
                        bfs(arr,check,j,k);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    static void bfs(char[][] arr, boolean[][] check, int x, int y){
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int n = arr.length;
        int m = arr[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x,y));
        check[x][y]= true;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx<0||ny<0||nx>n-1||ny>m-1)continue;
                    if(check[nx][ny])continue;
                    if(arr[nx][ny]=='.')continue;
                    q.offer(new Pair(nx,ny));
                    check[nx][ny]= true;
                }
            }
        }
    }
}
