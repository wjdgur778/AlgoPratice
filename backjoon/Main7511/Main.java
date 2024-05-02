package backjoon.Main7511;

import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static final int USER = 1000000;
    static int[] parents;
    public static int get_p(int n) {
        if (n == parents[n]) return n;
        else return parents[n] = get_p(parents[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append("Scenario "+(i+1)+":"+System.lineSeparator());
            int n = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            parents = new int[n];
            for (int j = 1; j < n; j++) {
                parents[j] = j;
            }
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int p_a = get_p(a);
                int p_b = get_p(b);
                if(p_a>p_b){
                    parents[p_a]=p_b;
                }
                else{
                    parents[p_b]=p_a;
                }
            }
            int M = Integer.parseInt(br.readLine());

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(get_p(a)==get_p(b)){
                    sb.append("1"+System.lineSeparator());
                }
                else
                    sb.append("0"+ System.lineSeparator());
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
