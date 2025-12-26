package backjoon.Main11266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int start = 0;
        answer = Math.max(answer,Integer.parseInt(st.nextToken()));
        for (int i = 1; i < size; i++) {
            int cur = Integer.parseInt(st.nextToken());
            int gap = cur - start;
            answer = Math.max(answer, gap % 2 == 0 ? gap / 2 : (gap / 2) + 1);
            start = cur;
        }
        //마지막
        answer = Math.max(answer, N - start);
        System.out.println(answer);
    }
}
