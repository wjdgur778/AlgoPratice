package backjoon.Main16947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static int[] dist;
    static boolean[] check;
    static int[] pre;
    static boolean done = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        check = new boolean[N + 1];
        dist = new int[N + 1];
        pre = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
            dist[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        check[1] = true;
        find(1);
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (dist[i] != 0)
                ans.append(calc_dist(i)+" ");
            else ans.append(0+" ");
        }
        ans.setLength(ans.length()-1);
        System.out.println(ans.toString());
    }

    static void find(int cur) {
        for (int i = 0; i < arr[cur].size(); i++) {
            int next = arr[cur].get(i);
            if(done)return;
            //cycle 조건 달성
            if (pre[cur] != next && check[next]) {
                dist[cur] = 0;
                while (cur != next) {
                    dist[pre[cur]] = 0;
                    cur = pre[cur];
                }
                done = true;
                return;
            }

            if (check[next]) continue;
            check[next] = true;
            pre[next] = cur;
            find(next);
        }
    }

    static int calc_dist(int cur) {
        int cnt = 0;
        boolean[] check = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);
        check[cur] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int c = q.poll();
                if (dist[c] == 0) return cnt;
                for (int j = 0; j < arr[c].size(); j++) {
                    int n = arr[c].get(j);
                    if (check[n]) continue;
                    check[n] = true;
                    q.offer(n);
                }
            }
            cnt++;
        }
        return cnt;
    }

}
