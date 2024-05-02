package Programmers.카카오2021_메뉴리뉴얼;

import java.util.*;

public class Solution {
    static Map<String,Integer> map;
    static int check[];
    public static void main(String[] args) {
        Solution a = new Solution();
        String[] orders={"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course={2,3,4};
        check = new int[11];
        map = new HashMap<String,Integer>();
        a.solution(orders,course);
    }
    /*
    result = ["ACD", "AD", "ADE", "CD", "XYZ"]
     */
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for(int i =0;i<orders.length;i++){
            // 2. 각 문자열을 문자형 배열로 변환.
            char[] charArr = orders[i].toCharArray();
            // 3. 해당 문자형 배열을 정렬.
            Arrays.sort(charArr);
            // 4. 정렬된 문자형 배열을 문자열로 변환해 저장.
            orders[i] = String.valueOf(charArr);
        }
        for (int i = 0; i <course.length ; i++) {
            for (int j = 0; j < orders.length; j++) {
                combi(orders[j],0,0,course[i],"");
            }
        }
        //여기가 포인트
        //Map 다루기
        //value를 기준으로 정렬
       Object[] a =  map.keySet().toArray();
       List<Map.Entry<String, Integer>>  aa =  new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(aa,(i,j)->j.getValue().compareTo(i.getValue()));
        List<String>ans = new ArrayList<>();
        for(Map.Entry<String,Integer> b : aa){
            if(b.getValue()>=2){
                if(check[b.getKey().length()]==0) {
                    ans.add(b.getKey());
                    check[b.getKey().length()]=b.getValue();
                }else {
                    if (check[b.getKey().length()] == b.getValue()) {
                        ans.add(b.getKey());
                    }
                }
            }
        }

        ans.sort((i,j)->i.compareTo(j));
        answer = ans.toArray(new String[ans.size()]);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }
    static void combi(String order,int idx,int cnt,int MAX,String tmp){
        if(cnt==MAX){
            if(map.containsKey(tmp)){
               map.put(tmp,map.get(tmp)+1);
            }
            else{
                map.put(tmp,1);
            }
            return;
        }
        for (int i = idx; i < order.length(); i++) {

            combi(order,i+1,cnt+1,MAX,tmp+order.charAt(i));
        }
    }
}
