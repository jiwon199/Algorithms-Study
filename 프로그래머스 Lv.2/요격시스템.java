import java.util.*;
 class Solution {
        //val의 0번 배열에 좌표, 1번배열에 요격되는 미사일 번호(1번배열의 길이=targets 길이)
        static HashMap<Integer, int [][]> group;
        static HashMap<Integer,Boolean> isBreak;
        static int n;
        public int solution(int[][] targets) {
            
            Arrays.sort(targets, (o1, o2) -> {
                return o1[0]-o2[0];
            });

            group=new HashMap<>();
            isBreak=new HashMap<>();
            n=targets.length;

            for(int i=0;i<n;i++){
                makeGroup(targets,i);
                isBreak.put(i,false);
            }
            return breakAttack();
             
 
        }
        public static void makeGroup(int [][] targets,int groupNum){
            int [][] info=new int [2][n];
            int idx=0;
            info[1][idx]=groupNum;
            if(groupNum==n-1){
                info[0][0]=targets[groupNum][0];
                info[0][1]=targets[groupNum][1];
            }
            else{
                int start=targets[groupNum][0];
                int end=targets[groupNum][1];

                for(int i=groupNum+1;i<n;i++){
                    int nextStart=Math.max(start,targets[i][0]);
                    int nextEnd=Math.min(end,targets[i][1]);
                    if(isAble(end,targets[i][0],nextStart,nextEnd)){
                        idx++;
                        info[1][idx]=i;
                        start=nextStart;
                        end=nextEnd;
                    }
                    else{
                        break;
                    }
                }
                info[0][0]=start;
                info[0][1]=end;

            }
            info[0][2]=idx+1;
            group.put(groupNum,info);
        }
        public static boolean isAble(int firstE, int secS,int nextS,int nextE){
            if(nextS>=nextE||nextS>=firstE||nextE<=secS) return false;
            else return true;
        }
        public static int breakAttack(){
            int cnt=0; //요격한 미사일 갯수
            int ans=0; //선택한 그룹의 수
            while(true){
                if(cnt>=n) break;
                cnt+=selectGroup();
                ans++;

            }
            return ans;
        }
        //그룹 선택하고 요격한 새 미사일의 개수 리턴
        public static int selectGroup(){
            //모든 그룹 중에서 요격하지 않은 미사일을 가장 많이 포함하는 그룹 택1
            int max=-1;
            int selectGroup=-1;
             
            for(int i=0;i<n;i++){
                int [][] info=group.get(i);
                int cnt=0;
                for(int j=0;j<info[0][2];j++){
                    if(!isBreak.get(info[1][j])) cnt+=1;
                }
                if(cnt>=max){
                    selectGroup=i;
                    max=cnt;
                }
                
            }
            
            int [][] selectInfo=group.get(selectGroup);
            for(int i=0;i<selectInfo[0][2];i++){
                isBreak.put(selectInfo[1][i],true);
            }
            
            return max;
            
            
        }
 }
