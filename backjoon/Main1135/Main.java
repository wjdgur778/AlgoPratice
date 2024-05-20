package backjoon.Main1135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] cnt;
    static int N;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = new int[N];
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) arr[i] = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp==-1)continue;
            arr[tmp].add(i);
        }
        System.out.println(solve(0));
        /*
           자리수를 생각하자
         */
    }

    private static int solve(int cur) {
        if(arr[cur].size()==0)return 0;
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i <arr[cur].size() ; i++) {
            tmp.add(solve(arr[cur].get(i)));
        }
        Collections.sort(tmp,Collections.reverseOrder());
        int comp = 0;

        for (int i = 0; i <tmp.size(); i++) {
            int num = tmp.get(i)+i+1;
            if(i==0)
                comp = num;
            else{
                if(comp < num){
                    comp = num;
                }
            }
        }

        return comp;
    }
}
