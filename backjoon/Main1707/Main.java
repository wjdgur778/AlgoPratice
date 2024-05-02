package backjoon.Main1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, V, E;
    static ArrayList<Integer>[] arr;
    static int[] check_arr;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            arr = new ArrayList[V+1];
            check_arr = new int[V+1];
            for (int j = 1; j <= V; j++) {
                arr[j] =new ArrayList<Integer>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(j==0)start=a;
                arr[a].add(b);
                arr[b].add(a);
            }
            solution(start);
        }
    }

    private static void solution(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        check_arr[s]=1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                int cur_check = check_arr[cur];
                for (int j = 0; j < arr[cur].size(); j++) {
                    int next = arr[cur].get(j);
                    if(check_arr[next]==cur_check){
                        System.out.println("NO");
                        return;
                    }
                    if(check_arr[next]!=0)continue;
                    q.offer(next);
                    check_arr[next]=cur_check*-1;
                }
            }
        }
        System.out.println("YES");
        return;
    }
}
