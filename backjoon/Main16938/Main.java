package backjoon.Main16938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준이는 문제를 N개 가지고 있고, 모든 문제의 난이도를 정수로 수치화했다. i번째 문제의 난이도는 Ai이다.
 *
 * 캠프에 사용할 문제는 두 문제 이상이어야 한다. 문제가 너무 어려우면 학생들이 멘붕에 빠지고, 문제가 너무 쉬우면 학생들이 실망에 빠지게 된다. 따라서, 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다. 또, 다양한 문제를 경험해보기 위해 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다.
 *
 * 캠프에 사용할 문제를 고르는 방법의 수를 구해보자.
 */
public class Main {
    static int N,L,R,X;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solution(0,0,new ArrayList());
        System.out.println(answer);
    }
//    15 C 7 = 13*1*11*5*9 /
    private static void solution(int idx, int cnt, ArrayList<Integer> list) {
        //2개이상를 택하되 수들의 합이 L과 R 사이이고 가장 작은수와 큰수의 차가 X보다 크거가 같아야함
        //N은 15개이하
//      조합을 하되 조건이 있는 조합 -> 시간복잡도 충분
        if(cnt>=2){
            int sum=0;
            if(list.get(list.size()-1)-list.get(0)>=X) {
                for (int i : list) {
                    sum += i;
                }
                if(sum>=L&&sum<=R){
                    answer++;
                }
            }
        }
        if(cnt==N)return;
        for (int i = idx; i < N; i++) {
            list.add(arr[i]);
            solution(i+1,cnt+1,list);
            list.remove(list.size()-1);
        }
    }
}
