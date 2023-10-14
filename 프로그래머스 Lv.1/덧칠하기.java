import java.util.*;
class Solution {
    static int wall []; //칠해진 벽 0, 안칠해진 벽 1
    static int sections [];
    static int N,M,D;
    static int answer;
    public int solution(int n, int m, int[] section) {
        wall=new int[n];
            for(int info: section){
                wall[info-1]=1;
            }
            M=m;
            N=n;
            D=section.length;
            sections=new int[D];
            for(int i=0;i<D;i++){
                sections[i]=section[i];
            }
            answer=0;
            coloring(0);
           
            

            return answer;
    }
    static void coloring(int d){
        if(d==D){
            return;
        }
        else{
            int k=sections[d]-1;
            if(wall[k]==0) coloring(d+1);
            else{
                answer+=1;
                for(int i=k;i<k+M;i++){
                    if(i==N) break;
                    wall[i]=0;
                }
                coloring(d+1);
            }
        }
         
         
    }
   
}
