package backjoon.Main1504;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair> {
    int v;
    long w;
    Pair(int v, long w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Pair o) {
        return Long.compare(this.w, o.w);
    }
}

public class Main {
    static int N, E, V1, V2;
    static int answer;
    static ArrayList<Pair>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[a].add(new Pair(b, w));
            arr[b].add(new Pair(a, w));
        }
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());
        //  1 -> V1 -> V2 -> N 까지!
        long f = dijkstra(1, V1);
        f= f==Long.MAX_VALUE?0:f;
        long s = dijkstra(V1, V2);
        s= s==Long.MAX_VALUE?0:s;
        long t = dijkstra(V2, N);
        t= t==Long.MAX_VALUE?0:t;
        long _f = dijkstra(1, V2);
        _f= _f==Long.MAX_VALUE?0:_f;
        long _s = dijkstra(V2, V1);
        _s= _s==Long.MAX_VALUE?0:_s;
        long _t = dijkstra(V1, N);
        _t= _t==Long.MAX_VALUE?0:_t;
        //하나라도가면 그친구가 답
        //둘다 가면 둘중 최소
        boolean flag_1 = (f==-1||s==-1||t==-1);
        boolean flag_2 = (_f==-1||_s==-1||_t==-1);
        /*
3 3
1 3 20
1 2 15
2 3 6
1 3
         */
        //둘다 못가면 -1
        if(flag_1&&flag_2){
            System.out.println(-1);
        }
        else if (!flag_1&&flag_2){
            System.out.println(f+s+t);
        }
        else if (flag_1&&!flag_2){
            System.out.println(_f+_s+_t);
        }
        else {
            System.out.println((f+s+t)<(_f+s+_t)?(f+s+t):(_f+s+_t));
        }
    }

    private static long dijkstra(int s, int e) {
        int sum = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(s, 0));
        long INF = Long.MAX_VALUE;
        long[] dist = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                if (cur.v == e) return dist[cur.v];
                if (cur.w > dist[cur.v]) continue;
                for (int j = 0; j < arr[cur.v].size(); j++) {
                    Pair next = arr[cur.v].get(j);
                    if (dist[next.v] > next.w + cur.w) {
                        dist[next.v] = next.w + cur.w;
                        q.offer(new Pair(next.v, dist[next.v]));
                    }
                }
            }
        }
        return -1;
    }

}