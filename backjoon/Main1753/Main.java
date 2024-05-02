package backjoon.Main1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int v, w;

    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(w,o.w);
    }
}

public class Main {
    static int V, E;
    final static int INF = 987654321;
    static int start;
    static ArrayList<Node>[] arr;
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        arr = new ArrayList[V + 1];
        dist = new int[V+1];

        for (int i = 1; i < V + 1; i++) {
            arr[i] = new ArrayList<Node>();
            dist[i]=INF;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,w));
        }
        logic();
        for (int i = 1; i < V+1; i++) {
            if(dist[i]==INF)System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
    static void logic(){
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.offer(new Node(start,0));
        dist[start]=0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i <size ; i++) {
                Node cur = q.poll();
                if(cur.w>dist[cur.v])continue;
                for (int j = 0; j <arr[cur.v].size() ; j++) {
                    int nv = arr[cur.v].get(j).v;
                    int nw = arr[cur.v].get(j).w;
                    if(cur.w+nw<dist[nv]) {
                        dist[nv] = cur.w + nw;
                        q.offer(new Node(nv, cur.w + nw));
                    }
                }
            }
        }

    }
}
