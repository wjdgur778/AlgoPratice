package backjoon.Main18428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Data{
        int x;
        int y;
        Data(int x, int y){
            this.x = x;
            this.y =y ;
        }
    }
    static int N;
    static String[][] arr;
    static ArrayList<Data> teacher;
    static ArrayList<Data> student;
    static ArrayList<Data> Xs;
    static boolean f=true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        teacher = new ArrayList<>();
        student = new ArrayList<>();
        Xs = new ArrayList<>();
        arr = new String[N][N];

        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <N ; j++) {
                arr[i][j] = st.nextToken();
                if(arr[i][j].equals("S"))student.add(new Data(i,j));
                if(arr[i][j].equals("T"))teacher.add(new Data(i,j));
                if(arr[i][j].equals("X"))Xs.add(new Data(i,j));

            }
        }
        combi(0,0);
        if(f)System.out.println("NO");
        else  System.out.println("YES");

    }

    public static void combi(int idx,int cnt) {
        if(cnt==3){
            if(check()){
                f=false;
            }
            return;
        }
        if(f){
            for (int i = idx; i < Xs.size(); i++) {
                Data cur = Xs.get(i);
                arr[cur.x][cur.y] = "O";
                combi(i+1,cnt+1);
                arr[cur.x][cur.y] = "X";
            }
        }
    }
    public static boolean check(){
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};

        for (int i = 0; i <teacher.size() ; i++) {
            Data cur = teacher.get(i);
            for (int j = 0; j < 4; j++) {
                int nx = cur.x+dx[j];
                int ny = cur.y+dy[j];
                while(((nx>=0&&nx<=N-1)&&(ny>=0&&ny<=N-1))&&!arr[nx][ny].equals("S")){

                    if(arr[nx][ny].equals("O"))break;
                    nx+=dx[j];
                    ny+=dy[j];

                }
                if((nx>=0&&nx<=N-1)&&(ny>=0&&ny<=N-1)&&arr[nx][ny].equals("S"))return false;
            }
        }
        return true;

    }

}
