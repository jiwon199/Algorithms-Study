import java.util.*;
class Solution {
    List <List> list=new ArrayList<>();
    public int solution(int n, int[][] results) {
        int answer = 0;
         
        for(int i=0;i<n;i++){
            List <Set> info=new ArrayList<>();
            Set <Integer> set1=new HashSet<>();
            Set <Integer> set2=new HashSet<>();
            info.add(set1);
            info.add(set2);
            list.add(info);
        }
        
        for(int [] res: results){
            int winner=res[0]-1;
            int loser=res[1]-1;
            compute(winner,loser);
        }
        
        for(int i=0;i<n;i++){
            Set <Integer> set=(HashSet)list.get(i).get(0);
            Set <Integer> set2=(HashSet)list.get(i).get(1);
            if(set.size()+set2.size()==n-1) {
                answer++;
            }
        }
        return answer;
    }
    public void compute(int winner,int loser){
        Set <Integer> set=(HashSet)list.get(winner).get(0);
        Set <Integer> set2=(HashSet)list.get(loser).get(1);
        //set에 loswer가 등록됐고 set2에 winner가 등록됐다면
        if(check(winner,loser)){
            return;
        }
        else{
            set.add(loser);
            set2.add(winner);
            
            //winner를 이긴 모든 애들은 loser를 이김
            Set <Integer> winnerGroup=(HashSet)list.get(winner).get(1);
            for(int win:winnerGroup){
                compute(win,loser);
            }
            
            //loser에게 진 모든 애들은 winner에게 짐
            Set <Integer> loserGroup=(HashSet)list.get(loser).get(0);
            for(int lose:loserGroup){
                compute(winner,lose);
            }
        }
    }
    public boolean check(int winner,int loser){
        Set <Integer> set=(HashSet)list.get(winner).get(0);
        Set <Integer> set2=(HashSet)list.get(loser).get(1);
        
        for(int num:set){
            if(num==loser) return true;
        }
        
        for(int num:set2){
            if(num==winner) return true;
        }
        return false;
    }
}
