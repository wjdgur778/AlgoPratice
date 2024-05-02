package backjoon.Main2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x =x;
        this.y =y;
    }
}
public class Main {
    static int M, N, K;
    static int[][] arr;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int count;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        answer = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            for (int j = y; j <= y1; j++) {
                for (int k = x; k <= x1; k++) {
                    arr[j][k]=1;
                }
            }
        }
        solution();
    }
    static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j]==1)continue;
                count++;
                bfs(i,j);
            }
        }
        System.out.println(count);
        answer.sort((i,j)->{
            return Integer.compare(i,j);
        });
        for(int i : answer){
            System.out.print(i+" ");
        }
    }
    static void bfs(int x,int y){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x,y));
        arr[x][y]=1;
        int sum=0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                sum++;
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx<0||ny<0||nx>N-1||ny>M-1)continue;
                    if(arr[nx][ny]==1)continue;
                    arr[nx][ny]=1;
                    q.offer(new Pair(nx,ny));
                }
            }
        }
        answer.add(sum);
    }
}
