package backjoon.Main18116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    //union find?
    // 1000000
    static int[] parents;
    static int[] counts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        parents = new int[1000005];
        counts = new int[1000005];
        for (int i = 1; i < 1000005 ; i++) {
            parents[i] = i;
            counts[i]=1;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if("I".equals(cmd)){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int p_a = get_p(a);
                int p_b = get_p(b);
                //부모가 다르면 연결
                if(p_a!=p_b){

                    if(p_a<p_b){
                        parents[p_b]=p_a;
                        counts[p_a]+=counts[p_b];
                        counts[p_b]=0;
                    }
                    else {
                        parents[p_a]=p_b;
                        counts[p_b]+=counts[p_a];
                        counts[p_a]=0;
                    }
                }
            }
            else{
                int c = Integer.parseInt(st.nextToken());
                System.out.println(counts[get_p(c)]);
            }
        }

    }
    static int get_p(int cur){

        if(parents[cur]==cur)return cur;
        else{
            return parents[cur] = get_p(parents[cur]);
        }
    }
}

