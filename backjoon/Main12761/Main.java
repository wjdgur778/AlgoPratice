package backjoon.Main12761;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,A,B;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // init
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[100001];


        System.out.println( bfs());
    }
    public static int bfs(){
        Queue<Integer> q= new LinkedList<>();
        int cnt =0;
        q.offer(N);
        check[N]=true;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if(cur==M)return cnt;
                if(cur-1>=0&&!check[cur-1]){
                    q.offer(cur-1);
                    check[cur-1]=true;
                }
                if(cur+1<=100000&&!check[cur+1]) {
                    q.offer(cur+1);
                    check[cur+1]=true;
                }

                if(cur-A>=0&&!check[cur-A]){
                    q.offer(cur-A);
                    check[cur-A]=true;
                }
                if(cur+A<=100000&&!check[cur+A]){
                    q.offer(cur+A);
                    check[cur+A]=true;
                }

                if(cur-B>=0&&!check[cur-B]){
                    q.offer(cur-B);
                    check[cur-B]=true;
                }
                if(cur+B<=100000&&!check[cur+B]){
                    q.offer(cur+B);
                    check[cur+B]=true;
                }

                if(cur*A<=100000&&!check[cur*A]){
                    q.offer(cur*A);
                    check[cur*A]=true;
                }
                if(cur*B<=100000&&!check[cur*B]){
                    q.offer(cur*B);
                    check[cur*B]=true;
                }
            }
            cnt++;
        }
        return 0;
    }
}
