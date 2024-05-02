package backjoon.Main5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        check = new boolean[1000001];
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int bfs = bfs();
        if (bfs == -1) System.out.println("use the stairs");
        else System.out.println(bfs);
    }

    public static int bfs() {
        //1층 ~ F층 사이어야 하고 내가 넘어갈때 그 사이가 아니면 skip
        Queue<Integer> q = new LinkedList<>();
        int[] go = new int[2];
        go[0] = U;
        go[1] = -D;
        q.offer(S);
        int count = 0;
        check[S] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int ii = 0; ii < size; ii++) {
                int cur = q.poll();
                if (cur == G) return count;

                for (int i = 0; i < 2; i++) {
                    int next = cur + go[i];
                    if (next < 1 || next > F) continue;
                    if (check[next]) continue;
                    check[next] = true;
                    q.offer(next);
                }
            }
            count++;
        }
        return -1;
    }
}
