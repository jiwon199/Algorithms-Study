import java.util.*;
class Solution {
    public void bfs(int start,boolean [] visited,int[][] computers,int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while(!queue.isEmpty()) {
            int node=queue.poll();
            for(int i=0;i<n;i++){
                if (i==node){
                    continue;
                }
                else if(computers[node][i]==1&&visited[i]==false){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
         
        boolean [] visited=new boolean[n];
        for(int node=0;node<n;node++){
            if (visited[node]==false){
                bfs(node,visited,computers,n);      
                answer+=1;
            }
             
        }
        return answer;
    }
}
