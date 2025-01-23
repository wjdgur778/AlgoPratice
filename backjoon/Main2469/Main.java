package backjoon.Main2469;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int hidden_idx;
    static int[] result;
    static char[][] arr;
    static boolean stop=false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        result = new int[k];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i) - 65;
        }

        arr = new char[n][(k - 1) * 2 + 1];
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < ((k - 1) * 2) + 1; j++) {

                //짝수에는 '0'를
                //홀수에는 str을 집어넣는다.
                if (j % 2 == 0) arr[i][j] = '0';
                else {
                    arr[i][j] = str.charAt(j / 2);
                    if (arr[i][j] == '?') hidden_idx = i;
                }
            }
        }
        combi(0, '*');
        combi(0, '-');

        StringBuilder sb= new StringBuilder();

        for (int i = 0; i <arr[hidden_idx].length ; i++) {
            if(i%2!=0)sb.append(arr[hidden_idx][i]);
        }

        if(stop) {
            System.out.println(sb.toString());
        }
        else{
            sb = new StringBuilder();
            for (int i = 0; i < k-1; i++) {
                sb.append('x');
            }
            System.out.println(sb.toString());
        }

    }

    static void combi(int cnt, char cur) {
        if (cnt == k-1) {
            if (check_possible()) {
                stop=true;
                return;
            }
            return;
        }
        if(!stop){
            arr[hidden_idx][cnt * 2 + 1] = cur;
            if(cur=='-')
                combi(cnt + 1, '*');
            else{
                combi(cnt + 1, '*');
                combi(cnt + 1, '-');
            }
        }
    }
    /*
    0*0-0*0*0*0-0*0*0*0
    0-0*0-0*0*0*0*0*0*0
    0?0?0?0?0?0?0?0?0?0
    0-0*0*-0*0*0*0-0*0
    0*0*0-0*0-0*0-0*0-0
     */
    static boolean check_possible() {

        for (int jj = 0; jj < k; jj++) {
            int j = jj*2;
            int i = 0;
            while (i < n) {
                if (j - 2 >= 0 && arr[i][j - 1] == '-') {
                    j -= 2;
                    i++;
                } else if (j + 2 < ((k-1) * 2) + 1 && arr[i][j + 1] == '-') {
                    j += 2;
                    i++;
                } else {
                    i++;
                }
            }
            //j는 도착한 지점, jj는 시작한 친구
            if (result[j / 2] != jj) return false;
        }
        return true;
    }
}
