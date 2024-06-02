package backjoon.Main1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        // N < 100,000
        PriorityQueue<Long>pq = new PriorityQueue<Long>();
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        if(pq.size()==1){
            System.out.println(0);
            return;
        }


        while(pq.size()>1){
            long a = pq.poll();
            long b = pq.poll();
            answer += a+b;
            pq.offer(a+b);
        }

        System.out.println(answer);

    }
}
