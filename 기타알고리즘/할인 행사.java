import java.util.*;
class Solution {
    Map <String,Integer> map=new HashMap<>();
    Map <String,Integer> target=new HashMap<>();
    int cnt=0;
    
    public int solution(String[] want, int[] number, String[] discount) {
         
        for(int i=0;i<number.length;i++){
            target.put(want[i],number[i]);
        }
        for(String item:discount){
            map.put(item,0);
        }
        
        for(int i=0;i<10;i++){
            int before=map.get(discount[i]);
            map.put(discount[i],before+1);
        }
        cnt+=check(want);
        
        for(int i=1;i<=discount.length-10;i++){
            int before=map.get(discount[i-1]);
            map.put(discount[i-1],before-1);
            
            int next=map.get(discount[i+9]);
            map.put(discount[i+9],next+1);
            cnt+=check(want);
            
        }
        return cnt;
    }
    public int check(String[] want){
        for(int i=0;i<want.length;i++){
            if(target.getOrDefault(want[i],0)>map.getOrDefault(want[i],0)) return 0;
        }
        
        return 1;
    }
}
