package backjoon.Main12919;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static String S;
    static String T;
    static int Ta;
    static int Tb;
    static boolean stop;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        T = sc.next();
        dfs(T);
        if (stop) System.out.println(1);
        else System.out.println(0);
    }

    private static void dfs(String s) {
        if (s.isEmpty()) return;
        if ((s.length() == S.length())) {
            if (s.equals(S)) stop = true;
            return;
        }
        if (s.charAt(s.length() - 1) == 'A')
            dfs(remove(s));
        if (s.charAt(0) == 'B')
            dfs(reverse(s));
    }
    private static String remove(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(0);
        sb.reverse();
        return sb.toString();
    }

}
