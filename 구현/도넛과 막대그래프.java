class Solution {
    public int[] solution(int[][] edges) {
            int [][] info=new int[1000001][2];

            int allgraph=0; //모든 그래프의 수
            int line=0; //막대형
            int eight=0; //8자형
            int create=0; //생성된 정점
            int N=0; // 가장 큰 정점
            
            for(int i=0;i< edges.length;i++){
                int out=edges[i][0];
                int in=edges[i][1];

                info[out][0]++;
                info[in][1]++;
                
                int tmp=Math.max(out,in);
                N=Math.max(N,tmp);
            }

            //out 2 이상, in 0 이면 생성된 정점 O(n)
            for(int i=0;i<N;i++){
                if(info[i][0]>=2 &&info[i][1]==0){
                    create=i;
                    allgraph=info[create][0];
                    break;
                }
            }
            //생성된 정점을 그래프에서 제거
            for(int i=0;i< edges.length;i++){
                int out=edges[i][0];
                int in=edges[i][1];
                if(out==create){
                    info[in][1]--;
                }
            }
            //막대형과 8자형의 갯수를 센다.
            for(int i=1;i<=N;i++){
               if(info[i][0]==0){
                    line++;
                }
                else if(info[i][0]==2&&info[i][1]==2){
                    eight++;
                }
              
            }

            return new int [] {create,allgraph-(line+eight),line,eight};
    }
}
