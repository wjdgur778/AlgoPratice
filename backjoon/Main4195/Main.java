package backjoon.Main4195;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int n;
    static HashMap<String, Integer> map;
    static int[] f_cnt;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //init
        N = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());
            map = new HashMap<String, Integer>();
            f_cnt = new int[(n * 2) + 1];
            parents = new int[(n * 2) + 1];
            int idx = 0;

            Arrays.fill(f_cnt, 1);
            for (int j = 0; j < n * 2; j++) {
                parents[j] = j;
            }
            for (int j = 0; j < n; j++) {
                String[] tmp = br.readLine().split(" ");
                String str1 = tmp[0];
                String str2 = tmp[1];

                //string에 해당하는 idx 기억하기
                if (!map.containsKey(str1)) {
                    map.put(str1, idx++);
                }
                if (!map.containsKey(str2)) {
                    map.put(str2, idx++);
                }

                int idx1 = map.get(str1);
                int idx2 = map.get(str2);

                int a = get_p(idx1);
                int b = get_p(idx2);

                if (a != b) {
                    a = get_p(idx1);
                    b = get_p(idx2);
                    if (a < b) {
                        f_cnt[a] += f_cnt[b];
                        parents[b] = a;
                        System.out.println(f_cnt[a]);
                    } else {
                        f_cnt[b] += f_cnt[a];
                        parents[a] = b;
                        System.out.println(f_cnt[b]);
                    }
                } else {
                    System.out.println(f_cnt[a]);
                }
            }

        }

    }

    static int get_p(int cur) {
        if (parents[cur] == cur) return cur;
        else return parents[cur] = get_p(parents[cur]);
    }
}

