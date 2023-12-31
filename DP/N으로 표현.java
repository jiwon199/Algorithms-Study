import java.util.*;
class Solution {
    //dp[i]는 N을 i개 사용해서 만들 수 있는 수들의 집합
    public List <Set <Integer> > dp=new ArrayList<>();
    public int solution(int N, int number) {
        int answer=-1;

         dp.add(new HashSet<>()); //dp[0]
         //N을 8개보다 많이 써야하면 -1 리턴하므로 제한은 8로 둔다.
         //N, NN,NNN ...추가
         for(int i=1;i<=8;i++){
             Set <Integer> set=new HashSet<>();
             String s=String.valueOf(N).repeat(i);
             set.add(Integer.valueOf(s));
             dp.add(set);
         }


         for(int i=2;i<=8;i++){
             for(int j=1;j<i;j++){
                 //만약 dp[4] 이면 dp[1]+dp[3] ,dp[2]+dp[2], dp[3]+dp[1] 의 조합을 집합에 추가해야 함.
                 //반복문으로 모든 조합 검사
                 for(int num1:dp.get(j)){
                     for(int num2: dp.get(i-j)){
                         dp.get(i).add(num1+num2);
                         dp.get(i).add(num1-num2);
                         dp.get(i).add(num1*num2);
                         if(num2!=0){
                             dp.get(i).add(num1/num2);
                         }
                     }
                 }
             }
         }

         for(int i=1;i<=8;i++){
             if(dp.get(i).contains(number)){
                 answer=i;
                 break;
             }
         }


         return answer;
    }
}
