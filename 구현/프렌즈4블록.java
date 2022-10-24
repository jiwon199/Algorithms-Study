import java.util.*;
class Solution {
    char [][] graph;
    List <int []> memo; //지워질 곳
    int [][] graphMemo;
    Queue <int []> q; //빈칸
    int answer,n,m;
    int [] dx={0,1,0,1};
    int [] dy={0,0,1,1};
    public int solution(int r, int c, String[] board) {
        n=r;
        m=c;
        graph=new char[n][m];
        memo=new LinkedList<>();
        graphMemo=new int[n][m];
        q=new LinkedList<>();
        answer=0;
         
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                graph[i][j]=board[i].charAt(j);
            }
        }
        
        while(true){
            if(pop()==false) break;
            checkBlank();
            memo.clear();
            clearGraph();
            
        } 
        
        return answer;
    }
    
    public boolean pop(){
        int cnt=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                if(graph[i][j]!='.')
                    check(i,j);
            }
        }
         
        //모두 팝 시킨다.
        for(int [] info: memo){
            System.out.println(Arrays.toString(info));
            cnt+=1;
            graph[info[0]][info[1]]='.';
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graphMemo[i][j]==1){
                    cnt+=1;
                    graph[i][j]='.';
                    memo.add(new int []{i,j});
                }
            }
        }
        answer+=cnt;
        
        if(cnt==0) return false;
        else return true;
         
    }
    public void check(int i,int j){
        char now=graph[i][j];
        boolean flag=true;
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(graph[x][y]!=now) flag=false;
        }
        if(flag){
            for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            graphMemo[x][y]=1;
            }
        }
        
         
        
    }
    public void checkBlank(){
         for(int [] info:memo){
             //모든 빈칸에 대해
             int x=info[0];
             int y=info[1];
             //맨 위가 아니고
             if(x!=0){
                 //위가 인형이면 
                 if(graph[x-1][y]!='.'){
                     q.add(new int [] {x-1,y});
                 }
             }
         }
        drop();
        
    }
    public void drop(){
        while(!q.isEmpty()){
            int [] info=q.poll();
            int x=info[0];
            int y=info[1];
            int height=getHeight(x,y);  
            List <int []> now=getList(x,y);  
            
            for(int [] droping: now){
                graph[droping[0]+height][droping[1]]=graph[droping[0]][droping[1]];
                graph[droping[0]][droping[1]]='.';
            }
            
        }
    }
    public int getHeight(int r,int c){
        int cnt=0;
        for(int i=r+1;i<n;i++){
            if(graphMemo[i][c]==0) break;
            cnt+=1;
        }
        return cnt;
    }
    public List<int []> getList(int r,int c){
        List<int []> myList=new ArrayList<>();
        int x=r;
        int y=c;
        while (true){
            if(x==-1) break;
            if(graph[x][y]=='.') break;
            myList.add(new int []{x,y});
            x-=1;
        }
        return myList;
    }
    public  void clearGraph(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                graphMemo[i][j]=0;
            }
        }
    }
     
   
   
}
