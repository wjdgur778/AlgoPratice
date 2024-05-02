package backjoon.Main10994;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별찍기
 * <p>
 * <p>
 * ************
 * *
 * ********* *
 * *       * *
 * * ***** * *
 * * *   * * *
 * * * * * * *
 * * *   * * *
 * * ***** * *
 * *       * *
 * ********* *
 * *
 * ************
 */
public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[(N - 1) * 4 + 1][(N - 1) * 4 + 1];
        init_print(N, 0, 0);
        print();
    }

    private static void init_print(int n, int x, int y) {
        if(n==0)return;
        int h_num = (n - 1) * 4 + 1;
        int w_num = (n - 1) * 4 + 1;
        for (int i = x; i < x + h_num; i++) {
            for (int j = y; j < y + w_num; j++) {
//                if(i%2!=0)continue;
//                else{
                    if(i!=x&&i!=x+h_num-1){
                        if(j==y||j==y+w_num-1) arr[i][j]=1;
                    }
                    else arr[i][j]=1;
//                }
            }
        }
        init_print(n-1,x+2,y+2);
    }
    public static void print(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]==1)
                System.out.print("*");
                else
                    System.out.print(" ");
            }
            if(i!=arr.length-1)
            System.out.println();
        }
    }
}
