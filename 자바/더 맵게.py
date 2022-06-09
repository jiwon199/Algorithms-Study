import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n=scoville.length;
        for (int i=0;i<n;i++){
            queue.add(scoville[i]);             
        }
        
        while(true){
            
            if (queue.size()==1){
                if (queue.poll()<K){
                    answer=-1;
                }
                break;
            }
            int first=queue.poll();
            int sec=queue.poll();
            if (first>=K){
                break;
            }
            queue.add(first+sec*2);
            answer+=1;
                        
        }
        
        return answer;
    }
}
