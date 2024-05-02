package backjoon.Main17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Data{
    int x;
    int y;
    Data(int x ,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static ArrayList<Data> virus;
    static int answer = Integer.MAX_VALUE;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        virus = new ArrayList<Data>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2) virus.add(new Data(i,j));
            }
        }

        //logic
        combination(0,0,new LinkedList<Data>());

        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(answer-1);
    }

    private static void combination(int cnt, int idx, LinkedList<Data> t_virus) {
        if(cnt == M){
            boolean able = true;
            int b_num = bfs(t_virus);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(check[i][j])continue;
                    if(arr[i][j]==1)continue;
                    able = false;
                }
            }
            if(able) answer = Math.min(answer,b_num);
            return;
        }
        for(int i =idx;i<virus.size();i++){
            t_virus.add(virus.get(i));
            combination(cnt+1,i+1,t_virus);
            t_virus.removeLast();
        }
    }

    private static int bfs(LinkedList<Data> t_virus) {
        System.out.println();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int cnt=0;
        Queue<Data> q = new LinkedList<Data>();
        check = new boolean[N][N];
        for (int i = 0; i < t_virus.size(); i++) {
            Data cur = t_virus.get(i);
            check[cur.x][cur.y] = true;
            q.offer(cur);
        }
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Data cur = q.poll();
//                System.out.println(cur.x+" "+cur.y);
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx<0||ny<0||nx>N-1||ny>N-1)continue;
                    if(arr[nx][ny]==1)continue;
                    if(check[nx][ny])continue;
                    q.offer(new Data(nx,ny));
                    check[nx][ny]=true;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
