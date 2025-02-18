package backjoon.Main5569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mod = 100000;
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        long[][][]arr = new long[h][w][4];

        //0 1 2 3
        //dd dr rd rr

        for (int i = 0; i <w ; i++)arr[0][i][3]=1;
        for (int i = 0; i <h ; i++)arr[i][0][0]=1;

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {

                arr[i][j][0] = (arr[i-1][j][0] + arr[i-1][j][2]) % mod;
                arr[i][j][1] =(arr[i][j-1][0]) % mod;
                arr[i][j][2] =(arr[i-1][j][3]) % mod;
                arr[i][j][3] =(arr[i][j-1][1] + arr[i][j-1][3]) % mod;
            }
        }


        System.out.println((arr[h-1][w-1][0]+arr[h-1][w-1][1]+arr[h-1][w-1][2]+arr[h-1][w-1][3])%mod);
    }
}
