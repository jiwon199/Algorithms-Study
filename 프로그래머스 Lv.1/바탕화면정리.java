import java.util.*;
class Solution {
    static int [][] map;
    static int n;
    static int m;
    //static int [] answer=new int[4]; //lux(최소), luy(최소) rdx(최대), rdy(최대)
    public int[] solution(String[] wallpaper) {
            int [] answer=new int[4]; //lux(최소), luy(최소) rdx(최대), rdy(최대)
            n=wallpaper.length;
            m=wallpaper[0].length();
            map=new int[n][m];
            answer[0]=Integer.MAX_VALUE;
            answer[1]=Integer.MAX_VALUE;

            for(int i=0;i<n;i++){
                
                for(int j=0;j<m;j++){
                    if(wallpaper[i].charAt(j)=='#') {
                        //값 갱신
                        if(i<answer[0]) answer[0]=i; 
                        if(i>answer[2]) answer[2]=i;
                        if(j<answer[1]) answer[1]=j;
                        if(j>answer[3]) answer[3]=j;
                    }

                }
            }
            answer[2]++;
            answer[3]++;
            return answer;
    }
}
