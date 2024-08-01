package backjoon.Main16139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] sum = new int[26];
        int n = str.length();
        map = new int[26][n+1];
        for (int i = 0; i < n; i++) {
            int idx = str.charAt(i)-97;
            if(i==0){
                map[idx][i]=1;
                continue;
            }
            for (int j = 0; j <26; j++) {
                if(j==idx)
                    map[j][i]=map[j][i-1]+1;
                else
                    map[j][i]= map[j][i-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmp = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int idx = cmp.charAt(0)-97;
            if(a==0)
                sb.append(map[idx][b]+"\n");
            else
                sb.append((map[idx][b]-map[idx][a-1])+"\n");
        }
        System.out.println(sb);
    }
}
/*
seungjaehwang
4
a 6 6
a 0 6
a 6 10
a 7 10
 */