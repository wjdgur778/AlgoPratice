package backjoon.Main9996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String[] pattern = s.split("[*]");
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(s.length()-1<=str.length()&&str.startsWith(pattern[0]) && str.endsWith(pattern[1]))System.out.println("DA");
            else System.out.println("NE");
        }
    }
}
