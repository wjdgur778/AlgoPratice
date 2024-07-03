package backjoon.Main14716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[][] arr;
    static int[] dx ={0,1,0,-1,1,1,-1,-1};
    static int[] dy ={1,0,-1,0,1,-1,-1,1};
    static boolean[][] visited;
    static class Pair{
        int x;
        int y;
        Pair(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < N ; j++) {
                if(visited[i][j])continue;
                if(arr[i][j]==0)continue;
                solve(i,j);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void solve(int x,int y) {
        Queue<Pair>q = new LinkedList<Pair>();
        q.offer(new Pair(x,y));
        visited[x][y]=true;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = cur.x+dx[j];
                    int ny = cur.y+dy[j];
                    if(nx<0||ny<0||nx>M-1||ny>N-1)continue;
                    if(visited[nx][ny])continue;
                    if(arr[nx][ny]==1){
                        visited[nx][ny]=true;
                        q.offer(new Pair(nx,ny));
                    }
                }
            }
        }
    }
}
