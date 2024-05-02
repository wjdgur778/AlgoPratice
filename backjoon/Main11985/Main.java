package backjoon.Main11985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k;
    static int[] oranges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        oranges = new int[n];
        for (int i = 0; i <n ; i++) {
            oranges[i]=Integer.parseInt( new StringTokenizer(br.readLine()).nextToken());
        }
        solution();
    }
    static void solution(){

    }
}
