package backjoon.Main20436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static HashMap<String,Pair> map;
    public static void main(String[] args)throws IOException {
        /*
            qwertyuiop
            asdfghjkl
            zxcvbnm
         */
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        init();

        Pair l = map.get(st.nextToken());
        Pair r = map.get(st.nextToken());

        String target = br.readLine();

        for (int i = 0; i < target.length(); i++) {
            String ch = String.valueOf(target.charAt(i));
            Pair cur = map.get(ch);
            int l_dist = Math.abs(l.x-cur.x)+Math.abs(l.y-cur.y);
            int r_dist = Math.abs(r.x-cur.x)+Math.abs(r.y-cur.y);
            if(cur.y<5&&!"b".equals(ch)) {
                l = cur;
                answer += l_dist;
            }
            else{
                r = cur;
                answer+=r_dist;
            }
        }
        System.out.println(answer+target.length());


    }
    static void init(){
        map = new HashMap<String,Pair>();

        map.put("q",new Pair(0,0));
        map.put("w",new Pair(0,1));
        map.put("e",new Pair(0,2));
        map.put("r",new Pair(0,3));
        map.put("t",new Pair(0,4));
        map.put("y",new Pair(0,5));
        map.put("u",new Pair(0,6));
        map.put("i",new Pair(0,7));
        map.put("o",new Pair(0,8));
        map.put("p",new Pair(0,9));

        map.put("a",new Pair(1,0));
        map.put("s",new Pair(1,1));
        map.put("d",new Pair(1,2));
        map.put("f",new Pair(1,3));
        map.put("g",new Pair(1,4));
        map.put("h",new Pair(1,5));
        map.put("j",new Pair(1,6));
        map.put("k",new Pair(1,7));
        map.put("l",new Pair(1,8));

        map.put("z",new Pair(2,0));
        map.put("x",new Pair(2,1));
        map.put("c",new Pair(2,2));
        map.put("v",new Pair(2,3));
        map.put("b",new Pair(2,4));
        map.put("n",new Pair(2,5));
        map.put("m",new Pair(2,6));
    }
}
