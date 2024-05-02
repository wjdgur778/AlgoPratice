package backjoon.Main13023;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 13023
 * https://www.acmicpc.net/problem/13023
 * <p>
 * BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
 * <p>
 * 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
 * <p>
 * A는 B와 친구다.
 * B는 C와 친구다.
 * C는 D와 친구다.
 * D는 E와 친구다.
 * 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 */

public class Main {
    static int N, M;
    static List<Integer>[] arr;
    static boolean f;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        f = true;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            check = new boolean[N];
            check[i] = true;
            solution(1, i);
        }
        if (f == false) System.out.println(1);
        else System.out.println(0);
    }

    public static void solution(int cnt, int idx) {
        if (cnt == 5) {
            f = false;
            return;
        }
        for (int i = 0; i < arr[idx].size(); i++) {

            if (f && check[arr[idx].get(i)] == false) {
                check[idx] = true;
                solution(cnt + 1, arr[idx].get(i));
                check[idx] = false;
            }
        }
    }
}
