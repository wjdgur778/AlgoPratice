package backjoon.Main15558;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] rows = new String[2];
    static int N;
    static int k;
    static boolean finish = false;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        rows[0] = br.readLine();
        rows[1] = br.readLine();
        check = new boolean[2][N];
        dfs(0,0,-1);
        if(finish)System.out.println(1);
        else System.out.println(0);
    }

    private static void dfs(int cur,int idx,int remove) {
        if(idx+1>N-1||idx+k>N-1){
            //done
            finish = true;
            return;
        }
        //go forward
        if(!check[cur][idx+1]&&rows[cur].charAt(idx+1)=='1'){
            check[cur][idx+1]=true;
            if(!finish)dfs(cur,idx+1,remove+1);
            check[cur][idx+1]=false;
        }
        //go backward
        if(idx-1>=0&&!check[cur][idx-1]&&rows[cur].charAt(idx-1)=='1'&&idx-1>remove+1){
            check[cur][idx-1]=true;
            if(!finish)dfs(cur,idx-1,remove+1);
            check[cur][idx-1]=false;

        }
        //move to the other row
        if(!check[(cur+1)%2][idx+k]&&rows[(cur+1)%2].charAt(idx+k)=='1'){
            check[(cur+1)%2][idx+k]=true;
            if(!finish)dfs((cur+1)%2,idx+k,remove+1);
            check[(cur+1)%2][idx+k]=false;
        }
    }
}
