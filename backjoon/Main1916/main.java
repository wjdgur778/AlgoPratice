package backjoon.Main1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int c;
    int w;

    public Pair(int c, int w) {
        this.c = c;
        this.w = w;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.w, o.w);
    }
}

public class main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int s, e;
    static ArrayList<Pair>[] arr;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<Pair>();
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[a].add(new Pair(b, w));
//            arr[b].add(new Pair(a, w));
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        solution();
    }

    private static void solution() {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(s, 0));
        dist[s]=0;
        while(!pq.isEmpty()){
            Pair cur = pq.poll();

            if(dist[cur.c]<cur.w)continue;

            for (int i = 0; i < arr[cur.c].size(); i++) {
                int n_c = arr[cur.c].get(i).c;
                int n_w = cur.w+arr[cur.c].get(i).w;
                if(dist[n_c]>n_w){
                    dist[n_c] = n_w;
                    pq.offer(new Pair(n_c,n_w));
                }

            }
        }
        System.out.println(dist[e]);
    }
}
