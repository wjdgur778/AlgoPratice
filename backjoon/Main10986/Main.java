package backjoon.Main10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static long[] arr;
    static long[] mod;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[1000000];
        mod = new long[1000];
        // 누적합
        for (int i = 0; i < N; i++) {
            if(i==0) arr[i] =Integer.parseInt(st.nextToken());
            else arr[i] +=arr[i-1] + Integer.parseInt(st.nextToken());
        }
        // 만들어진 누적합을 이용
        // 누적합들을 M으로 나눈 나머지를 그룹화
        // 그룹화된 친구들끼리 빼면 (나머지가 0이됨) M으로 나눈 나머지가 0인 특정 구간이 나온다.
        // 즉 그룹화된 친구들의 수를 comi한 수만큼이 답이됨
        for (int i = 0; i <N; i++) {
            mod[(int) (arr[i]%M)]++;
        }
        //combi한 수를 모두 더함
        for (int i = 0; i < M ; i++) {
            answer+= (long)(mod[i]*(mod[i]-1))/2;
        }
        answer += mod[0];
        System.out.println(answer);
    }
}
