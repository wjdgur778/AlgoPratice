package backjoon.Main16960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16960
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int button = 0;
        int lamp = 0;

        button = Integer.parseInt(st.nextToken());
        lamp = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr= new ArrayList[button];
        int[] check = new int[lamp];

        for (int i = 0; i < button; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Integer>tmp = new ArrayList<Integer>();
            for (int j = 0; j < n; j++){
                int l = Integer.parseInt(st.nextToken())-1;
                tmp.add(l);
                check[l]++;
            }
            arr[i] = tmp;
        }
        for (int i = 0; i < button; i++) {
            boolean f = false;
            for(int idx : arr[i]){
                if(check[idx]<=1){
                    f= true;
                    break;
                }
            }
            if(f==false){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
