//import java.util.*;
//
//// 2 ~ 9 진법중 어느 진법을 사용한것인지 (중복 가능) 확인
//// 확인 후 불확실하다면 ? , 확실하다면 확실한 답을 채워 넣는다.
//// 각각의 숫자중 가장 큰 수 +1 ~ 9 까지 가능하다.
//class Solution {
//    public ArrayList<String> solution(String[] expressions) {
//        ArrayList<String>answer = new ArrayList<String>();
//
//        ArrayList<Integer> x_arr = new ArrayList<Integer>();
//        int max = 0;
//        for(int i =0 ;i<expressions.length;i++){
//            String[] str = expressions[i].split(" ");
//            // i = 1 은 연산자
//            // i = 0, i = 2 , i = 4(결과)
//            for(int j =0 ;j<5;j+=2){
//                for(int k=0;k<str[j].length();k++){
//                    if(str[j].charAt(0)=='X'){
//                        x_arr.add(i);
//                        break;
//                    }
//                    max = Math.max(max,str[j].charAt(k)-'0');
//                }
//            }
//        }
//
//        // 가능한 진법 able 리스트에 넣기
//        ArrayList<Integer> able = new ArrayList<Integer>();
//        for(int i =max+1;i<10;i++) {
//            if(check(expressions,i))able.add(i);
//        }
//
//        // 가능한 진법이 여러개면 모두 같은지 확인 -> 모두 같다면 그게 정답, 같지않다면 ?가 정답
//        // 가능한 진법이 하나라면 그 진법으로 계산
//        if(able.size()==1){
//            for(int idx : x_arr){
//                StringBuilder sb = new StringBuilder(expressions[idx]);
//                sb.setLength(sb.length()-1);
//                sb.append(String.valueOf(calc(expressions[idx],able.get(0))));
//                answer.add(sb.toString());
//            }
//        }
//        else{
//            for(int idx : x_arr){
//                boolean f = false;
//                String result = "-1";
//                StringBuilder sb = new StringBuilder(expressions[idx]);
//                sb.setLength(sb.length()-1);
//
//                for(int i =0;i<able.size();i++){
//                    if(i==0)
//                        result = calc(expressions[idx],able.get(i));
//                    else
//                    if(!result.equals(calc(expressions[idx],able.get(i)))) {
//                        f = true;
//                        break;
//                    }
//                }
//                if(f) sb.append("?");
//                else sb.append(result);
//
//                answer.add(sb.toString());
//            }
//        }
//
//        return answer;
//    }
//    public boolean check(String[] expressions, int n){
//        for(int i =0 ;i<expressions.length;i++){
//            String[] str = expressions[i].split(" ");
//            int num1=0;
//            int num2=0;
//            int cnt = 0;
//            int result =0;
//            //전체 expression이 n진법으로 계산했을때 모두 true 라면 그 해당 진법으로 X 를 계산
//            //첫번째 수
//            for(int j = str[0].length()-1;j>=0;j--){
//                num1 += (str[0].charAt(j)-'0') * (int)Math.pow(n,cnt++);
//            }
//            cnt = 0;
//            //두번째 수
//            for(int j = str[2].length()-1;j>=0;j--){
//                num2 += (str[2].charAt(j)-'0') * (int)Math.pow(n,cnt++);
//            }
//            //결과
//            if(str[4].equals("X"))continue;
//
//            cnt=0;
//            for(int j = str[4].length()-1;j>=0;j--){
//                result += (str[4].charAt(j)-'0') * (int)Math.pow(n,cnt++);
//            }
//            //덧셈
//            if(str[1].equals("+")){
//                //해당 식은 n 진법 불가능 하므로 다음으로
//                if(num1+num2!=result)return false;
//            }
//            //뺄셈
//            else{
//                //해당 식은 n 진법 불가능 하므로 다음으로
//                if(num1-num2!=result)return false;
//            }
//        }
//        //모두 가능하다면 가능한 진법
//        return true;
//    }
//    public String calc(String expression,int n){
//        String[] str = expression.split(" ");
//        StringBuilder sb = new StringBuilder();
//        int cnt =0 ;
//        int num1=0;
//        int num2=0;
//        int result =0;
//        //전체 expression이 n진법으로 계산했을때 모두 true 라면 그 해당 진법으로 X 를 계산
//        //첫번째 수
//        for(int j = str[0].length()-1;j>=0;j--){
//            num1 += (str[0].charAt(j)-'0') * (int)Math.pow(n,cnt++);
//        }
//        cnt=0;
//        //두번째 수
//        for(int j = str[2].length()-1;j>=0;j--){
//            num2 += (str[2].charAt(j)-'0') * (int)Math.pow(n,cnt++);
//        }
//
//        // 25
//        // 25 / 2 = 12 ... 1
//        // 12 / 2 = 6 ... 0
//        // 6 / 2 = 3 ... 0
//        // 3 / 2 = 1 ... 1
//        // 1 / 2 = 0 ...1
//        if(str[1].equals("+")){
//            result = num1 + num2;
//        }
//        else
//            result = num1-num2;
//
//        if(result==0)return "0";
//
//        while(result>0){
//            sb.append(result%n);
//            result/=n;
//        }
//
//        return sb.reverse().toString();
//    }
//
//}