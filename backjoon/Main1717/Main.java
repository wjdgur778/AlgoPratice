package backjoon.Main1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int n, m;

    //  union 과 find를 나누어서 생각해볼까?
//  결국엔 함께해도 상관없었던거 같은데
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                union(b, c);
            } else {
                if(find(b)==find(c))
                    System.out.println("yes");
                else System.out.println("no");
            }
        }
    }

    private static int find(int c) {
        if(parents[c]==c)return c;
        else return parents[c] = find(parents[c]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            if(pa<pb){
                parents[pb]=parents[pa];
            }
            else {
                parents[pa]=parents[pb];
            }
        }
    }
}

