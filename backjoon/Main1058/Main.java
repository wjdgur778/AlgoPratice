package backjoon.Main1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        int answer = 0 ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N];
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(arr[i][j]=='Y'){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            answer = Math.max(bfs(i,graph),answer);
        }
        System.out.println(answer);
    }

    private static int bfs(int s,ArrayList<Integer>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[graph.length];
        int cnt = 0;
        int level = 0;
        q.offer(s);
        check[s]=true;
        while(!q.isEmpty()&&level<2){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int j = 0; j < graph[cur].size(); j++) {
                    int next = graph[cur].get(j);
                    if(check[next])continue;
                    check[next] = true;
                    q.offer(next);
                    cnt++;
                }
            }
            level++;
        }
        return cnt;
    }
}
