package backjoon.Main13397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < M ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution());
    }

/*
    조건이 있는곳 or <= 이 있는 곳에서 mid 를 가져오면 될것같다. (추측..?)
     */
    public static int solution() {
        int s =0;
        int e = 10000;
        int mid = 0;
        int answer=0;
        while(s<=e){
            mid = (s+e)/2;
//            System.out.println(mid);
            if(check(mid)) {
                e = mid-1;
                answer = mid;
            }
            else {
                s= mid+1;
            }
        }
        return answer;
    }
    /**
     * 8 3
     * 1 5 4 6 2 1 3 7
     */
    public static boolean check(int val) {
        int cnt=0;
        int minVal = 10001;
        int maxVal = -1;
        for (int i = 0; i < M ; i++) {
            minVal = Math.min(minVal,arr[i]);
            maxVal = Math.max(maxVal,arr[i]);

//          커지는 순간에 새로운 구간 탐색
            if(maxVal - minVal>val){
                maxVal=minVal=arr[i];
                cnt++;
            }
        }
        return cnt<N;
    }

}
