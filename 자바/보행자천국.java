import java.util.*;
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
         
        String [][] count=new String [m][n];
        int [][] answer=new int [m][n];
        for (int i=0;i<m;i++){
            if (cityMap[i][0]!=1){
                count[i][0]="0,1";
            }  
            else{
              count[i][0]="0,0";  
            }
        }
        for(int i=0;i<n;i++){
            if (cityMap[0][i]!=1){
                count[0][i]="1,0";
            }
            else{
               count[i][0]="0,0";   
            }
        }
       
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                count[i][j]="0,0";
            }     
        }
         
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                 //갈 수 없는 곳이면 경우의 수 0
                if (cityMap[i][j]==1){
                    continue;
                }
                else{
                    String [] up=count[i-1][j].split(",");
                    String [] left=count[i][j-1].split(",");
                    int upLeft=Integer.parseInt(up[0])%MOD;
                    int upUp=Integer.parseInt(up[1])%MOD;
                    int leftLeft=Integer.parseInt(left[0])%MOD;
                    int leftUp=Integer.parseInt(left[1])%MOD;
                    //위,옆이 모두 2
                    if (cityMap[i-1][j]==2 && cityMap[i][j-1]==2){
                        count[i][j]=Integer.toString(leftLeft)+","+Integer.toString(upUp); 
                        answer[i][j]=(leftLeft+upUp)%MOD;
                    }
                    //위만 2 
                    else if(cityMap[i-1][j]==2){
                       count[i][j]=Integer.toString(leftLeft+leftUp)+","+Integer.toString(upUp); 
                       answer[i][j]=(leftLeft+leftUp+upUp)%MOD;
                    }
                    //옆만 2
                    else if(cityMap[i][j-1]==2){
                        count[i][j]=Integer.toString(leftLeft)+","+Integer.toString(upLeft+upUp);
                        answer[i][j]=(leftLeft+upLeft+upUp)%MOD;
                    }
                    //그 외
                    else{                       
                        count[i][j]=Integer.toString(leftLeft+leftUp)+","+Integer.toString(upLeft+upUp);
                        answer[i][j]=(leftLeft+leftUp+upLeft+upUp)%MOD;
                    }
                    
                }
            }
             
        }
        
        String [] res=count[m-1][n-1].split(",");
        int l=Integer.parseInt(res[0]);
        int u=Integer.parseInt(res[1]);
         
        return answer[m-1][n-1];
    }
}
