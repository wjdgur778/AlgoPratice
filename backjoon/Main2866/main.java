package backjoon.Main2866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
    static int N,M;
    static boolean[] same;
    static char[][] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        same = new boolean[M];
        arr = new char[N][M];
// (n-1) - cnt

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
        System.out.println(solution());
    }

    private static int solution() {
        int count =0;
        for (int i = N-1; i >0 ; i--) {
            if(check(i))
                //같은 자리에서 같은지 확인
                 if(true){
                     count++;
                 }
            else return (N-1-count);
        }
        return  (N-1-count);
    }
/*
4 6
mrvica
mavicm
maricm
mateja
같은거 끼리 같아야 진짜 같은거잖아..
 */
    private static boolean check(int idx) {
        int[] check = new int[26];
        for (int i = 0; i <M ; i++) {
            if(check[arr[idx][i] - 97]>0){
                //같았던 자리에다가 넣어
                //return true;
                same[check[arr[idx][i]]]=true;
                same[i]=true;
            }
            else check[arr[idx][i] -97] = i;
        }
        return false;
    }
}
