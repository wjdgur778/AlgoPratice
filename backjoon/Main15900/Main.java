package backjoon.Main15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        check = new boolean[N+1];
        for (int i = 1; i <N+1 ; i++) {
            arr[i]=new ArrayList<Integer>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        check[1]=true;
        System.out.println(dfs(1,0)%2!=0?"Yes":"No");
    }
    static int dfs(int cur, int sum){
        boolean isLeaf = true;
        int tmp = 0;
        for(int c : arr[cur]) {
            if (check[c]) continue;
            isLeaf = false;
            check[c] = true;
            tmp += dfs(c, sum + 1);
        }
        if(isLeaf)return sum;
        else return tmp;
    }
}
// 1 2 3 4
// 0 1 2 3
