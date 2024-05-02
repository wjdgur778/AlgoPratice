package backjoon.Main2141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static long sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        //범위 0 ~ 20억
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            sum+=arr[i][1];
        }
        Arrays.sort(arr,(i,j)->{
            return Integer.compare(i[0],j[0]);
        });
        System.out.println(solution());
    }

    private static int solution() {
        long tmp =0;
//      홀수인 경우
        if(sum%2==1){
            sum/=2;
            sum++;
        }else sum/=2;
        for (int i = 0; i < N ; i++) {
            tmp+=arr[i][1];
            if(tmp>=sum){
                return arr[i][0];
            }
        }
        return 0;
    }
}
