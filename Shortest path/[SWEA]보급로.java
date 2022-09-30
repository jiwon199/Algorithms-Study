import java.util.*;
import java.io.*;
public class Solution {
 
    public static int [][] graph;
    public static int [][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());
         
        int [] dx= {-1,1,0,0};
        int [] dy= {0,0,-1,1};
        for(int tc=1;tc<=TC;tc++) {
            int n=Integer.parseInt(br.readLine());
            graph=new int[n][n];
            visited=new int[n][n];
             
            for(int i=0;i<n;i++) {
                String info=br.readLine();
                for(int j=0;j<n;j++) {
                    graph[i][j]=info.charAt(j)-'0';
                    visited[i][j]=Integer.MAX_VALUE;
                }
            }
             
            PriorityQueue <int []> q=new PriorityQueue<>((o1,o2)-> {return o1[0]-o2[0]; });
            q.add(new int [] {graph[0][0],0,0});
            visited[0][0]=0;
             
              
            while(!q.isEmpty()) {
                int [] pos=q.poll();
                  
                for(int i=0;i<4;i++) {
                    int nx=pos[1]+dx[i];
                    int ny=pos[2]+dy[i];
                    if(nx>=0&&ny>=0&&nx<n&&ny<n) {
                        int cost=pos[0]+graph[nx][ny];
                        if(cost<visited[nx][ny]) {
                            visited[nx][ny]=cost;
                            q.add(new int [] {cost,nx,ny});
                        }
                    }
                }
            }
             
            System.out.println("#"+tc+" "+visited[n-1][n-1]);
        }
 
    }
 
}
