package backjoon.Main2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//회전하는 큐
//https://www.acmicpc.net/problem/1021
public class Main {
    static int N;
    static int M;
    static LinkedList<Integer>list = new LinkedList<Integer>();
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            int target = nums[i];
            int s = 0;
            int e = list.size()-1;
            int cnt =0;
            while(s<=e){
                if(list.get(s)==target){
                    for (int j = 0; j < cnt; j++) {
                        int n = list.pollFirst();
                        list.addLast(n);
                    }
                    list.removeFirst();
                    ans+=cnt;
                    break;
                }
                else if(list.get(e)==target){
                    for (int j = 0; j < cnt; j++) {
                        int n = list.pollLast();
                        list.addFirst(n);
                    }
                    list.removeLast();
                    ans+=cnt+1;
                    break;
                }
                s++;
                e--;
                cnt++;
            }
        }
        System.out.println(ans);
    }
}
