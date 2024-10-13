package backjoon.Main1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static int M;

    //todo
    // 벽이 존재하던 존재하지 않던
    // check 대상이 되지 않는다
    // 단 그 해당 지점에 벽을 본인보다 더 작거나 같은 갯수 만큼 지나왔다면 continue;
    // 내가 해당 지역에 도달하는 최소치보다 작으면 갱신
    static class Data {
        int x;
        int y;
        int cnt;
        Data(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(solve());
    }

    private static int solve() {
        int w_cnt = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        Queue<Data> q = new LinkedList<Data>();
        int[][] check = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check[i][j] = -1;
            }
        }
        q.offer(new Data(0, 0,0));
        check[0][0]=0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Data cur  = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx<0||ny<0||nx>N-1||ny>M-1)continue;
                    //일단 한번은 도착한 경우(벽의 갯수와 상관없이 일단 도착했잖아)
                    if(check[nx][ny]!=-1){
                        //내가 가려고 하는 곳에 다른 친구가 더 적은 벽을 만나서 도착한 경우가 있다면
                        if(check[nx][ny]<=cur.cnt)continue;
                        // 살짝 돌아서 온게 더 벽을 적게 먹고 간다면?
                        // 그게 더 좋은 경우다.
                    }
                    //처음 도착하거나 내가 더 적은 경우
                    check[nx][ny]=cur.cnt;
                    if(arr[nx][ny]==1)q.offer(new Data(nx,ny,cur.cnt+1));
                    else q.offer(new Data(nx,ny,cur.cnt));
                }
            }
        }
        return check[N-1][M-1];
    }

}
