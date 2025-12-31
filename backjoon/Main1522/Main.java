package backjoon.Main1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt_a = 0;
        int answer = Integer.MAX_VALUE;
        char[] charArray = str.toCharArray();
        int size = charArray.length;
        for (int i = 0; i < size; i++) {
            cnt_a += charArray[i] == 'a' ? 1 : 0;
        }
        for (int i = 0; i < size; i++) {
            int cnt_b = 0;
            for (int j = i; j < i+cnt_a; j++) {
                cnt_b += charArray[j%size] == 'b' ? 1 : 0;
            }
            answer = Math.min(cnt_b,answer);
        }
        System.out.println(answer);

    }
}
