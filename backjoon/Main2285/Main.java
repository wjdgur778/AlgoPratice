package backjoon.Main2285;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Data  {
    long n;
    long cnt;
    Data(long n, long cnt){
        this.n = n;
        this.cnt = cnt;
    }
}

public class Main {
    static int N,ans;
    static ArrayList<Data> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        long w_sum =0 ;
        long sum =0 ;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Data(a,b));
            w_sum += b;
        }
        Collections.sort(arr,(i,j)->Long.compare(i.n,j.n));

        for (int i = 0; i < N; i++) {
            sum += arr.get(i).cnt;
            if((w_sum+1)/2<=sum) {
                System.out.println(arr.get(i).n);
                return;
            }
        }
        
        System.out.println(ans);
    }
}
