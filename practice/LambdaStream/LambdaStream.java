package practice.LambdaStream;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class LambdaStream {
    static class User{
        int id;
        String name;
        String pw;
        User(int id, String name, String pw){
            this.id = id;
            this.name = name;
            this.pw = pw;
        }
    }
    static class UserDto{
        String name;
        String profile;
        UserDto(String name , String profile){
            this.name = name;
            this.profile = profile;
        }
        public static UserDto from (User user){
            return new UserDto(user.name,user.name+user.id);
        }
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        List<UserDto> userDtoList1 = new ArrayList<>();
        List<UserDto> userDtoList2 = new ArrayList<>();
        /**
         * for문이 더 적절한지, stream api가 더 적절한지는,
         * 요구사항에 따라 달라질거같다.
         * 가령, 결과에 정렬이나 맵핑등의 여러 작업들이 필요로한다면 stream api 사용이 더 나을 것이고,
         * 그렇지 않고 일반적인 인덱싱 작업을 한다면 for 문이 나을 거 같다.
         *
         * 그냥 실험을 통해 알아보자.
         * */
        /**
         * #init
         * 1. DTO 변환 예제 속도비교
         *
         */
        for (int i = 0; i < 1000000; i++) {
            userList.add(new User(i,"a","123"));
        }



//      todo 1. DTO 변환 예제 속도비교

//      for문
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            userDtoList1.add(UserDto.from(userList.get(i)));
        }
        System.out.println("for 문 : " + (System.currentTimeMillis() - start) +"ms");

//      stream api
        long start_2 = System.currentTimeMillis();
        userDtoList2 = userList.stream()
                    .map(user -> UserDto.from(user))
                            .collect(Collectors.toList());
        System.out.println("stream api : "+  (System.currentTimeMillis() - start) +"ms");

////      todo 2. 엔티티 to DTO 속도비교
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            list.add(new User(i,"a","123"));
//        }
//        System.out.println();
//        System.out.println((double) (System.currentTimeMillis() - start)/100 );
//
//        long start_2 = System.currentTimeMillis();
//
//        System.out.println((System.currentTimeMillis() - start_2)/1000 );
    }

}
