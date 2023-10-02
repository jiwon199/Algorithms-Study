import java.util.*;
class Solution {
    static HashMap <String,Integer> rank= new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
            for(int i=0;i<players.length;i++){
                rank.put(players[i],i);
            }

            for(int i=0;i<callings.length;i++){
                swap(callings[i],players);
            }
            return players;
        }
        public void swap(String name,String [] players){
            int now=rank.get(name);  
            int next=now-1;  

            String tmp=players[next];
            players[next]= name;
            players[now]= tmp;

            rank.put(tmp,now);
            rank.put(name,next);
        }
}
