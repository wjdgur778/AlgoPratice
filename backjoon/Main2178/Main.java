package backjoon.Main2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M;
    static char[][]arr;
    static int[] dx= {0,1,0,-1};
    static int[] dy= {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][];
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
       System.out.println(bfs());
    }
    static int bfs(){
        int answer=1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        arr[0][0]=0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i <size ; i++) {
                Pair cur = q.poll();

                if(cur.x==N-1&&cur.y==M-1)return answer;
                for (int j = 0; j <4 ; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx<0||ny<0||nx>N-1||ny>M-1)continue;
                    if(arr[nx][ny]=='0')continue;
                    q.offer(new Pair(nx,ny));
                    arr[nx][ny]='0';
                }
            }
            answer++;
        }
        return answer;
    }
}
