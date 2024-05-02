package backjoon.Main14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int H;
    static int W;
    // 3 1 2 3 4 1 1 2
    // 시작 ~ 나와 같거나 큰 친구가 나오는 순간 나와 친구중에 작은 친구를 기준으로 list에
    // 쌓은 친구들을 뺀 값을 answer에 add
    static int[] arr;
    static Stack<Integer> stak;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= H; i++) {
            boolean f = false;
            int sum = 0;
            for (int j = 0; j < W; j++) {
                if (i <= arr[j]) {
                    if(f){
                        answer+=sum;
                        sum=0;
                    }
                    if (!f) f = true;
                } else {
                    //막혀있는공간이 있을 가능성
                    if (f) sum++;
                }
            }
        }
        System.out.println(answer);

    }

}
