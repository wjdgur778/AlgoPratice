package backjoon.Main14248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int start;
    static int answer;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        // 1 2 3 4 5 6 . . . . 401 402 403 ... 100000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        check[start - 1] = true;
        move(start - 1);

        System.out.println(answer);

    }

    private static void move(int cur) {
        answer = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        check[cur] = true;
        q.offer(cur);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int c = q.poll();
                int right = c + arr[c];
                int left = c - arr[c];
                if (right <= N - 1 && !check[right]) {
                    check[right] = true;
                    answer++;
                    q.offer(right);
                }
                if (left >= 0 && !check[left]) {
                    check[left] = true;
                    answer++;
                    q.offer(left);
                }
            }
        }

    }
}
