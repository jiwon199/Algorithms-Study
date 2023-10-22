import java.util.*;

class Solution {
    static Map <Character,Integer> map=new HashMap<>();
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int [targets.length];

            for(String word: keymap){
                for(int i=1;i<word.length()+1;i++){
                    char c=word.charAt(i-1);
                    if(map.containsKey(c)){
                        if(map.get(c)>i){
                            map.put(c,i);
                        }
                    }
                    else map.put(c,i);
                }
            }

            for(int i=0;i< targets.length;i++){
                int res=0;
                for(int j=0;j<targets[i].length();j++){
                    if(map.containsKey(targets[i].charAt(j))){
                        res+=map.get(targets[i].charAt(j));
                    }
                    else{
                        res=-1;
                        break;
                    }
                }
                answer[i]=res;
            }
            return answer;
    }
}
