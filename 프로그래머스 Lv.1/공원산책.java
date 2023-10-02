import java.util.*;
class Solution {
    static char graph [][];
        static int n;
        static int m;
        static int [] dx={-1,1,0,0};
        static int [] dy={0,0,-1,1};
        static int[] answer = new int [2];
        static boolean able=false;
        public int[] solution(String[] park, String[] routes) {

            n=park.length;
            m=park[0].length();
            graph=new char[n][m];

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    graph[i][j]=park[i].charAt(j);
                    if(graph[i][j]=='S'){
                        answer[0]=i;
                        answer[1]=j;
                    }
                }
            }

            for(String route : routes){
                String[] info = route.split(" ");
                char dir=route.charAt(0);
                int dis=Integer.parseInt(info[1]);
                if(info[0].equals("N")) move(answer[0],answer[1],0,dis);
                if(info[0].equals("S")) move(answer[0],answer[1],1,dis);
                if(info[0].equals("W")) move(answer[0],answer[1],2,dis);
                if(info[0].equals("E")) move(answer[0],answer[1],3,dis);
              
            }
            
            return answer;
        }
        static void move(int x,int y,int dir,int dis){
            int rx=x;
            int ry=y;
            able=true;
            for(int k=0;k<dis;k++){
                int nx=rx+dx[dir];
                int ny=ry+dy[dir];
                if(nx>=0&&ny>=0&&nx<n&&ny<m){
                    if(graph[nx][ny]=='X'){
                        able=false;
                        break;
                    }
                    else{
                        rx=nx;
                        ry=ny;
                    }
                }
                else{
                    able=false;
                    break;
                }
            }
            if(able){
                answer[0]=rx;
                answer[1]=ry;
            }


        }
}
