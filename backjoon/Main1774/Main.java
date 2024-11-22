package backjoon.Main1774;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static class Qdata {
        double idx_a;
        double idx_b;
        double dist;

        Qdata(double idx_a, double idx_b, double dist) {
            this.idx_a = idx_a;
            this.idx_b = idx_b;
            this.dist = dist;
        }
    }

    static double[][] arr;
    static int[] parents;
    static PriorityQueue<Qdata> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        arr = new double[N+1][2];
        pq = new PriorityQueue<Qdata>((o1, o2) -> Double.compare(o1.dist,o2.dist));

        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                pq.offer(new Qdata(i,j,calcDist(arr[i][0],arr[i][1],arr[j][0],arr[j][1])));
            }
        }
// M 개 만큼 미리 연결해놓기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        solve();
    }

    static double calcDist(double x1, double y1, double x2, double y2) {
        double dist = Math.pow(x1 - x2,2)+ Math.pow(y1 - y2,2);
        dist = Math.sqrt(dist);
        System.out.println(dist);
        return dist;
    }
// 크루스칼 수행
    static void solve() {
        int size = pq.size();
        double sum =0.00;
        for (int i = 0; i < size; i++) {
            Qdata cur= pq.poll();
            int a = get_p((int)cur.idx_a);
            int b = get_p((int)cur.idx_b);
            if(a==b)continue;
            else {
                union(a,b);
                sum+=cur.dist;
            }
        }

        System.out.println(Math.round(sum*100)/100.0);
    }

    static void union(int a, int b) {
        int pa = get_p(a);
        int pb = get_p(b);

        if (pa < pb) {
            parents[pb] =pa;
        } else
            parents[pa] = pb;
    }

    static int get_p(int cur) {
        if (parents[cur] == cur) return cur;
        else return parents[cur] = get_p(parents[cur]);
    }
}
