package backjoon.Main2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static ArrayList<Pair> arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<Pair>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Pair(a,b));
        }
        arr.sort((i,j)->{
            return Integer.compare(i.x,j.x);
        });
        int start = arr.get(0).x;
        int max = arr.get(0).y;
        for (int i = 1; i < N; i++) {
            if (arr.get(i).x <= max) {
                max = Integer.max(max, arr.get(i).y);
            } else {
                //계산 이후에 시작값 갱신
                answer += max - start;
                start = arr.get(i).x;
                max = arr.get(i).y;
            }
        }
        answer += max - start;
        System.out.println(answer);

    }
}
