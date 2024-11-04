package backjoon.Main20366;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
//     2 2 5 5 7 7 7 10
//     9 5   5 5 -> 4
//     9 2   5 5 -> 1
//     3 2   5 5
//     1 21 33 70 100 101
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr, (i, j) -> Integer.compare(i, j));

        int l1 = 0;
        int l2 = 1;
        int r1 = N - 1;
        int r2 = N - 2;
        //  1 2 3 4 4 4 98 100 102
        //  1 4 7 18 20 1000  20000
//      1 1 1 1 1 2 2 2 2 2
//      1 4 4 8 8 90 99 100
//      a< b < c < d
//      a + d vs b + c  -> 무조건 요거 -> 밖이랑 안으로
//      a + c vs b + d -> 절대
//      안에 있는 눈사람의 크기가
//      4개를 뽑아서 사용하고싶지만, 정렬이 되어있기때문에 이를 이용하자
//      안에 친구가 클때
//            r2를 -- or l1을 ++
//      안에 친구가 작을때
//            l2를 ++ or r1을 --
        for (int i = 0; i < N-3; i++) {
            for (int j = i+3; j <N ; j++) {
                calc(i,j,i+1,j-1);
            }
        }
        System.out.println(answer);
    }
    public static void calc(int l1,int r1, int l2, int r2){
        if(l2==r2)return;

        int outer = arr.get(l1) + arr.get(r1);
        int inner = arr.get(l2) + arr.get(r2);

        answer = Math.min(answer,Math.abs(outer-inner));
        //2 3 5 5 9

        if(outer < inner){
            calc(l1,r1,l2,r2-1);
        }
        else if (outer == inner){
            answer = 0;
            return;
        }
        else{
            calc(l1,r1,l2+1,r2);
        }

    }
}
