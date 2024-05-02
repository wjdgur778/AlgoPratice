package backjoon.Main14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static String[] arr;
    static String[] tmp;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];
        tmp = new String[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            tmp[i] = st.nextToken();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i].equals(tmp[j])){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
