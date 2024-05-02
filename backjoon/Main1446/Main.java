package backjoon.Main1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int e;
    int w;

    Pair(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.w, o.w);
    }

}

public class Main {

    static int[] dist;
    static int N;
    static int D;
    static ArrayList<Pair>[] arr;
    static PriorityQueue<Pair> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new ArrayList[D+2];
        dist = new int[D+2];
        pq = new PriorityQueue<>();
        for (int i = 0; i <=D; i++) {
            arr[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (end > D) continue;
            if (end - start < weight) continue;
            arr[start].add(new Pair(end, weight));
        }
        for (int i = 0; i <= D; i++) {
            arr[i].add(new Pair(i + 1, 1));
            dist[i] = Integer.MAX_VALUE;
        }
        bfs();
        System.out.println(dist[D]);
    }

    private static void bfs() {
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Pair cur = pq.poll();

                for (int j = 0; j < arr[cur.e].size(); j++) {
                    Pair next = arr[cur.e].get(j);
                    if (cur.w + next.w < dist[next.e]) {
                        pq.offer(new Pair(next.e, cur.w + next.w));
                        dist[next.e] = cur.w + next.w;
                    }
                }
            }
        }
    }
}
