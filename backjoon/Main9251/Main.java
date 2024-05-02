package backjoon.Main9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String A;
    static String B;
    static int[][] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        arr = new int[A.length()+1][B.length()+1];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if(A.charAt(i)==B.charAt(j))arr[i+1][j+1] =arr[i][j]+1;
                else arr[i+1][j+1]=  Integer.max(arr[i][j+1],arr[i+1][j]);
            }
        }
        System.out.println(arr[A.length()][B.length()]);
    }
}
