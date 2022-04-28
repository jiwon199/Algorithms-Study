 
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
         
        HashMap<String,Integer> map = new HashMap<>(); 
        HashMap<String,Integer> map2 = new HashMap<>();
        for (int i=0;i<id_list.length;i++){
            map.put(id_list[i],0);
            map2.put(id_list[i],0);
        }
        Set<String> set = new HashSet<String>();       
        for (int i=0;i<report.length;i++){
            set.add(report[i]);
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String combi=it.next();
            String [] users=combi.split(" ");
            int before=map.get(users[1]);
            map.put(users[1],before+1);
                
        }
        it = set.iterator();
        while (it.hasNext()){
            String combi=it.next();
            String [] users=combi.split(" ");
            if (map.get(users[1])>=k){
                int before=map2.get(users[0]);
                map2.put(users[0],before+1);
            }
        }
        for (int i=0;i<id_list.length;i++){
            answer[i]=map2.get(id_list[i]);
        }    

         
        return answer;
    }
}
