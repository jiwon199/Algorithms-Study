import java.util.*;
class Solution {
    int answer = 0;    
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public boolean check(String names, String[] datas){
        for (String data : datas) {
            int position1 = names.indexOf(data.charAt(0)); // 프렌즈 포지션1
            int position2 = names.indexOf(data.charAt(2)); // 프렌즈 포지션2
            char op = data.charAt(3); // 수식
            int index = data.charAt(4) -'0'; // 간격
            if (op == '=') {
                if (!(Math.abs(position1 - position2) == index+1)) return false;  
            } else if (op == '>') {
                if (!(Math.abs(position1 - position2) > index+1)) return false;
            } else if (op == '<') {
                if (!(Math.abs(position1 - position2) < index+1)) return false;
            }
        }
        return true;
    }
    public void dfs(String names,boolean[] isVisited, String[] datas){
        if (names.length()==7){
            if (check(names, datas)==true){
                answer+=1;
            }
        }
        else{
            for(int i=0;i<8;i++){
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    String name = names + friends[i];
                    dfs(name, isVisited, datas);
                    isVisited[i] = false;
                }
            }
        }
    }
    public int solution(int n, String[] data) {
        boolean[] isVisited = new boolean[8];
        dfs("", isVisited, data);
 
        return answer;
    }
}
