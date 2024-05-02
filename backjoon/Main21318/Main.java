package backjoon.Main21318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {
    int s, e;

    Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {
    static int N, Q;
    static int[] arr;
    static int[] tmp;
    static Pair[] question;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());
        question = new Pair[Q];
        for (int i = 0; i < Q ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            question[i]= new Pair(x,y);
        }
        solution();
    }

    private static void solution() {
        tmp[0] =0 ;
        //누적합
        for (int i = 1; i <N ; i++) {
            tmp[i]= (tmp[i-1]+(arr[i]<arr[i-1]?1:0));
        }
        for (int i = 0; i < Q ; i++) {
            System.out.println(tmp[question[i].e-1] - tmp[question[i].s-1]);
        }
    }
}
