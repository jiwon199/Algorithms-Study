import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
    int [][] board=new int[m][n];
    Queue <int []> queue  =new LinkedList<>(); 
    int tomato=0;
    for(int j=0;j<n;j++) {
	    	 for(int i=0;i<m;i++) {
        board[i][j]=sc.nextInt();
        if (board[i][j]==1){
          queue.add(new int [] {i,j});
        }
        else if(board[i][j]==0){
          tomato+=1;
        }
      }
    }   

 

    int [] dx={-1,1,0,0};
    int [] dy={0,0,-1,1};
    int day=0;
    while(!queue.isEmpty()){
      int done []=queue.poll();
      for(int i=0;i<4;i++){
        int nx=done[0]+dx[i];
        int ny=done[1]+dy[i];
        if (nx>=0 && ny>=0 && nx<m &&ny<n){
          if (board[nx][ny]==0){
            board[nx][ny]=board[done[0]][done[1]]+1;
            queue.add(new int [] {nx,ny});
             
          }
        }
      }
      
    }
    boolean flag=true;
    for (int i=0;i<m;i++){
      for(int j=0;j<n;j++){
                  
          if (board[i][j]>day){
            day=board[i][j];
          }
          if (board[i][j]==0){
            flag=false;
          }
        }
       
      }
    if (tomato==0){
      System.out.println(0);
    }
    else if (flag==true){
      System.out.println(day-1);
    }
    else{
       System.out.println(-1);
     }
        
    
  }
}
