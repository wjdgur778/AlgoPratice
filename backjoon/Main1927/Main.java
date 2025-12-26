package backjoon.Main1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args)throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(cur==0) System.out.println(pq.isEmpty()?0:pq.poll());
            else pq.offer(cur);
        }
    }
}
