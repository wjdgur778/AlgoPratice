package backjoon.Main15991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자 : 김정혁
 * 유형 : 다이나믹 프로그램밍
 * 문제 :
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 합은 대칭을 이루어야 한다.
 * 1+1+1+1
 * 1+2+1
 * 2+2
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 */

public class Main {
    static int t;
    final static int MOD = 1000000009;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        arr = new long[100001];
        arr[0]=1;arr[1]=1;arr[2]=2;arr[3]=2;arr[4]=3;arr[5]=3;arr[6]=6;

        //arr에 경우의수 채우기
        for (int i = 7; i <=100000 ; i++) {
            arr[i] = (arr[i-6]%MOD+arr[i-4]%MOD+arr[i-2]%MOD)%MOD;
        }
        //정답 출력
        for (int i = 0; i < t ; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(arr[num]);
        }
    }
}
