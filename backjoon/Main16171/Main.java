package backjoon.Main16171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String key = br.readLine();
        String[] cmp = target.split("[0-9]");
        StringBuilder sb = new StringBuilder();
        if (cmp.length==1) {
            if (target.contains(key)) System.out.println(1);
            else System.out.println(0);
        } else {
            for (int i = 0; i < cmp.length; i++) {
                sb.append(cmp[i]);
            }
            if (sb.toString().contains(key)) System.out.println(1);
            else System.out.println(0);
        }
    }

}
