import java.util.*;
    class Solution {
        public static int [][] graph;
        public static int n,m;
        public static int sx,sy,gx,gy;
        public static int [] dx={-1,1,0,0};
        public static int [] dy={0,0,-1,1};
        public int solution(String[] board) {
            int answer = 0;
            n=board.length;
            m=board[0].length();
            graph=new int[n][m];


            //그래프 세팅
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    char c=board[i].charAt(j);
                    graph[i][j]=Integer.MAX_VALUE;
                    if(c=='R'){
                        sx=i;
                        sy=j;
                        graph[i][j]=0;
                    }
                    else if(c=='D'){
                        graph[i][j]=-1;
                    }
                    else if(c=='G'){
                        gx=i;
                        gy=j;
                    }
                }
            }

            Queue <int []> queue=new LinkedList<>();
            queue.add(new int [] {sx,sy,0});

            while(!queue.isEmpty()){
                int [] info=queue.poll();
                int distance=info[2]+1;
                for(int i=0;i<4;i++){
                    int [] pos=findNext(i,info[0],info[1]);
                    if(graph[pos[0]][pos[1]]>distance){
                        graph[pos[0]][pos[1]]=distance;
                        queue.add(new int [] {pos[0],pos[1],distance});
                    }
                }


            }

            if(graph[gx][gy]==Integer.MAX_VALUE) graph[gx][gy]=-1;


            return graph[gx][gy];
        }
        public static int [] findNext(int dir, int x,int y){
            int [] next=new int[2];
            while(true){
                int nx=x+dx[dir];
                int ny=y+dy[dir];

                if(nx<0||ny<0||nx>=n||ny>=m) {
                    next[0]=x;
                    next[1]=y;
                    break;
                }
                if(graph[nx][ny]==-1) {
                    next[0]=x;
                    next[1]=y;
                    break;
                }
                x=nx;
                y=ny;

            }
            return next;
        }
    }

