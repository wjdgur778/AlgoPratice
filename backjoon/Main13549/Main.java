package backjoon.Main13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair {
    int n;
    int cnt;

    Pair(int n, int cnt) {
        this.n = n;
        this.cnt = cnt;
    }


}

public class Main {
    static int N;
    static int K;
    static final int MAX = 100000;
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;

    public static void main(String[] args) throws IOException {
//      N에서 K로 가는데 +1 or -1 or 무료로 *2
//      가장 빠른 시간
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[(MAX * 2) + 2];
        for (int i = 0; i < (MAX * 2) + 2; i++) {
            dist[i] = INF;
        }
        bfs();

        System.out.println(dist[K]);

    }

    private static void bfs() {
        PriorityQueue<Pair> q = new PriorityQueue<>((i, j) -> Integer.compare(i.cnt, j.cnt));
        q.offer(new Pair(N, 0));
        dist[N] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                if (dist[cur.n] < cur.cnt) continue;
                int a = cur.n + 1;
                int b = cur.n - 1;
                int c = cur.n * 2;
                if (a < (MAX * 2) + 1) {
                    if (dist[a] >= cur.cnt + 1) {
                        dist[a] = cur.cnt + 1;
                        q.offer(new Pair(a, cur.cnt + 1));
                    }
                }
                if (b >= 0) {
                    if (dist[b] > cur.cnt + 1) {
                        dist[b] = cur.cnt + 1;
                        q.offer(new Pair(b, cur.cnt + 1));
                    }
                }
                if (c < (MAX * 2) + 1) {
                    if (dist[c] > cur.cnt) {
                        dist[c] = cur.cnt;
                        q.offer(new Pair(c, cur.cnt));
                    }
                }
            }
        }
    }
}
