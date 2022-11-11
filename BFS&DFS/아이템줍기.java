import java.util.*;
class Solution {
    int [][] rectangle;
    int characterX,characterY,itemX,itemY,answer;
    int [][] graph=new int[102][102];
    int [] dx={-1,1,0,0,-1,-1,1,1};
    int [] dy={0,0,-1,1,-1,1,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = Integer.MAX_VALUE;
        this.rectangle=rectangle;
        this.characterX=characterX*2;
        this.characterY=characterY*2;
        this.itemX=itemX*2;
        this.itemY=itemY*2;
        
        //사각형 영역 색칠하기
        for(int [] pos:rectangle){
            coloring(pos[0]*2,pos[1]*2,pos[2]*2,pos[3]*2);
        }
          
        //바깥 좌표 하나 선택 후 bfs
        checkOut(0,0);
        checkBorder();
        computePath();
        
        return answer/2;
    }
    //사각형 표시하는 함수
    public void coloring(int x1,int y1,int x2,int y2){
         
        for(int x=x1;x<=x2;x++){
            for(int y=y1;y<=y2;y++){
                graph[x][y]=1;
            }
        }
    }
    //바깥 영역 표시하는 함수
    public void checkOut(int startX,int startY){
        Queue <int []> q=new LinkedList<>();
        q.add(new int [] {startX,startY});
        graph[startX][startY]=2;
        while(!q.isEmpty()){
            int [] now=q.poll();
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                
                if(nx>=0&&ny>=0&&nx<102&&ny<102){
                    if(graph[nx][ny]==0 ){
                         
                        graph[nx][ny]=2;
                        q.add(new int [] {nx,ny});
                    }
                }
            }
        }
    }
    //사각형 중 테두리만 3으로 표시
    public void checkBorder(){
        Queue <int []> q=new LinkedList<>();
        q.add(new int [] {characterX,characterY});
        graph[characterX][characterY]=3;
        while(!q.isEmpty()){
            int [] now=q.poll();
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                
                if(nx>=0&&ny>=0&&nx<102&&ny<102){
                    if(graph[nx][ny]==1&&isValid(nx,ny)){
                         
                        graph[nx][ny]=3;
                        q.add(new int [] {nx,ny});
                    }
                }
            }
        }
    }
    //새로운 위치의 근접8칸에 바깥 영역이 있는지 체크
    public boolean isValid(int x,int y){
        for(int i=0;i<8;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&ny>=0&&nx<102&&ny<102){
                if(graph[nx][ny]==2) return true;
            }
        }
        return false;
    }
    //최단 거리 계산
    public void computePath(){
        Queue <int []> q=new LinkedList<>();
        q.add(new int [] {characterX,characterY,0});
        boolean [][] visited=new boolean[102][102];
        visited[characterX][characterY]=true;
         
        int dir=-1; //0이나 1이면 가로 진행, 2나 3이면 세로 진행
        while(!q.isEmpty()){
            int [] now=q.poll();
            //System.out.println(now[0]+" "+now[1]+" "+now[2]+"|"+itemX+" "+itemY);
            if(now[0]==itemX&&now[1]==itemY){
                answer=now[2];
                break;
            }
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];
                
                if(nx>=1&&ny>=1&&nx<102&&ny<102){
                    if(graph[nx][ny]==3&&visited[nx][ny]==false){
                        visited[nx][ny]=true;
                         
                        q.add(new int [] {nx,ny,now[2]+1});
                        dir=i;
                    }
                }
            }
        }
        
    }
    
}
