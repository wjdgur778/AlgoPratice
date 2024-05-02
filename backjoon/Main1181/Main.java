package backjoon.Main1181;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        int a = sc.nextInt();
        for (int i = 0; i <a ; i++) {
            String s = sc.next().toString();
            arr.add(s);
        }
        arr.sort((i,j)->{
            if(i.length()==j.length())return i.compareTo(j);
            else return Integer.compare(i.length(),j.length());
        });
        System.out.println(arr.get(0));
        for (int i = 1; i <a ; i++) {
            if(arr.get(i).equals(arr.get(i-1)))continue;
             System.out.println(arr.get(i));
        }
    }

}
