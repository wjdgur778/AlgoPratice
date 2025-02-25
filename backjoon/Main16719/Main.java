package backjoon.Main16719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static char[] arr;
    static String target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        arr = new char[target.length()];
        for (int i = 0; i < target.length(); i++) {
            arr[i]=' ';
        }
        recur(0,target.length());
    }
    static void recur(int s,int e){
        if(s==e)return;
        char min_c = 100;//아스키 코드상 대문자보다 크다
        int min_idx = 0;
        //현재 범위에서 우선 사전 순인 친구를 고른다.
        for (int i = s; i < e; i++) {
            char c= target.charAt(i);
            if(min_c > c){
                min_c = c;
                min_idx = i;
            }
        }
        arr[min_idx] = min_c;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==' ')continue;
            System.out.print(arr[i]);
        }
        System.out.println();

        recur(min_idx+1,e);
        recur(s,min_idx);
    }
}
