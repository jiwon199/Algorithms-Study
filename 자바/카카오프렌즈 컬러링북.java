import java.util.*;
class Solution {
    public int bfs(int sx,int sy,boolean[][] visited,int[][] picture,int m,int n){
        Queue<int[]> queue = new LinkedList<>();
        int area=1;
        queue.add(new int [] {sx,sy});
        visited[sx][sy]=true;
        
        int [] dx={-1,1,0,0};
        int [] dy={0,0,-1,1};
        int color=picture[sx][sy];
        while (!queue.isEmpty())
        {
            int pos[]=queue.poll();
            int x=pos[0];
            int y=pos[1];
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if (nx>=0 && ny>=0 &&nx<m&&ny<n){
                    if (visited[nx][ny]==false && picture[nx][ny]==color){
                        visited[nx][ny]=true;
                        queue.add(new int [] {nx,ny});
                        area+=1;
                    }
                }
                    
            }
        } 
        System.out.println(area);
        return area;
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
         
        
        boolean [][] visited=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                visited[i][j]=false;
            }
        }
        
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (visited[i][j]==false&&picture[i][j]!=0){
                    int area=bfs(i,j,visited,picture,m,n);
                    numberOfArea+=1;
                    if (area>maxSizeOfOneArea){
                        maxSizeOfOneArea=area;
                    }
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea; 
       
        return answer;
    }
    
     
}
